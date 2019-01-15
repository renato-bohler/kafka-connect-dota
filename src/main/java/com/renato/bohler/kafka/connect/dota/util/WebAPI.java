package com.renato.bohler.kafka.connect.dota.util;

import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.renato.bohler.kafka.connect.dota.api.MatchHistoryApi;

public class WebAPI {

	private static final String GET_MATCH_HISTORY_URL = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001";
	private static final String GET_MATCH_HISTORY_BY_SEQUENCE_NUM_URL = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistoryBySequenceNum/V001";

	public static MatchHistoryApi getMatchHistory(String key) throws Exception {
		final URL url = new URL(GET_MATCH_HISTORY_URL + "?key=" + key);
		return new ObjectMapper().readValue(url, MatchHistoryApi.class);
	}

	public static MatchHistoryApi getMatchHistoryBySequenceNum(String key, Long matchSeqNum) throws Exception {
		final URL url = new URL(
				GET_MATCH_HISTORY_BY_SEQUENCE_NUM_URL + "?key=" + key + "&start_at_match_seq_num=" + matchSeqNum);
		return new ObjectMapper().readValue(url, MatchHistoryApi.class);
	}

}
