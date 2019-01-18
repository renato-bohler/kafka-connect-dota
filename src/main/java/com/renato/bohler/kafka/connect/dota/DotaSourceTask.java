package com.renato.bohler.kafka.connect.dota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.RateLimiter;
import com.renato.bohler.kafka.connect.dota.api.MatchApi;
import com.renato.bohler.kafka.connect.dota.api.MatchHistoryApi;
import com.renato.bohler.kafka.connect.dota.util.Version;
import com.renato.bohler.kafka.connect.dota.util.WebAPI;

public class DotaSourceTask extends SourceTask {
	private static final Logger log = LoggerFactory.getLogger(DotaSourceTask.class);
	private DotaSourceConnectorConfig config;

	private RateLimiter rateLimiter;

	private Long lastMatchSeqNum;

	@Override
	public String version() {
		log.info("DotA 2 version {}", Version.getVersion());
		return Version.getVersion();
	}

	@Override
	public void start(Map<String, String> map) {
		log.info("DotA 2 source starting...");
		this.config = new DotaSourceConnectorConfig(map);
		this.rateLimiter = RateLimiter.create(1000D / this.config.rateLimitMs);

		this.setInitialMatchSeqNum();
	}

	@Override
	public List<SourceRecord> poll() throws InterruptedException {
		// TODO: implement error handling (no results, status != 1, etc.)
		if (this.lastMatchSeqNum == null) {
			this.setInitialMatchSeqNum();
			return new ArrayList<>();
		}

		List<SourceRecord> records = new ArrayList<>(100);

		this.rateLimiter.acquire();

		try {
			MatchHistoryApi matchHistory = WebAPI.getMatchHistoryBySequenceNum(this.config.webApiKey,
					this.lastMatchSeqNum);

			List<MatchApi> matches = matchHistory.result.matches;
			for (MatchApi match : matches) {
				records.add(new SourceRecord(Collections.singletonMap("dota_matches", "match_seq_num"),
						Collections.singletonMap("match_seq_num", match.match_seq_num), this.config.matchesTopic,
						MatchApi.getSchema(), match.getStruct()));
			}

			this.lastMatchSeqNum = matches.get(matches.size() - 1).match_seq_num + 1;
		} catch (Exception e) {
			log.error("DotA 2 error on connection with WebAPI!", e);
		}
		return records;
	}

	@Override
	public void stop() {
		log.info("DotA 2 source connector stopping...");
	}

	private void setInitialMatchSeqNum() {
		try {
			MatchHistoryApi matchHistory = WebAPI.getMatchHistory(this.config.webApiKey);
			List<MatchApi> matchesOrdered = matchHistory.result.matches.stream()
					.sorted((m1, m2) -> m2.match_seq_num.compareTo(m1.match_seq_num)).collect(Collectors.toList());
			this.lastMatchSeqNum = matchesOrdered.get(0).match_seq_num;
		} catch (Exception e) {
			log.error("DotA 2 error while setting the inicial match_seq_num", e);
		}
	}
}