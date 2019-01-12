package com.renato.bohler.kafka.connect.dota;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.RateLimiter;
import com.renato.bohler.kafka.connect.dota.util.Version;

public class DotaSourceTask extends SourceTask {
	static final Logger log = LoggerFactory.getLogger(DotaSourceTask.class);
	DotaSourceConnectorConfig config;

	RateLimiter rateLimiter;
	private Schema keySchema;
	private Schema valueSchema;

	@Override
	public String version() {
		log.info("DotA 2 version {}", Version.getVersion());
		return Version.getVersion();
	}

	@Override
	public void start(Map<String, String> map) {
		log.info("DotA 2 source starting...");
		this.config = new DotaSourceConnectorConfig(map);
		this.rateLimiter = RateLimiter.create(this.config.rateLimitMs / 1000);

		SchemaBuilder keySchemaBuilder = SchemaBuilder.struct();
		keySchemaBuilder.name("keySchemaName");

		this.keySchema = keySchemaBuilder.build();

		SchemaBuilder valueSchemaBuilder = SchemaBuilder.struct();
		valueSchemaBuilder.name("valueSchemaName");
		this.valueSchema = valueSchemaBuilder.build();
	}

	@Override
	public List<SourceRecord> poll() throws InterruptedException {
		log.info("DotA 2 source polling...");

		this.rateLimiter.acquire();

		// TODO: implement
		List<SourceRecord> records = new ArrayList<>(100);
		return records;
	}

	@Override
	public void stop() {
		log.info("DotA 2 source connector stopping...");
	}
}