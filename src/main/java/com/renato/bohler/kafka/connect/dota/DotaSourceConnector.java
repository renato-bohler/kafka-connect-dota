package com.renato.bohler.kafka.connect.dota;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.renato.bohler.kafka.connect.dota.util.Version;

public class DotaSourceConnector extends SourceConnector {
	private static Logger log = LoggerFactory.getLogger(DotaSourceConnector.class);
	private DotaSourceConnectorConfig config;

	@Override
	public String version() {
		log.info("DotA 2 version {}", Version.getVersion());
		return Version.getVersion();
	}

	Map<String, String> settings;

	@Override
	public void start(Map<String, String> map) {
		this.settings = map;
		config = new DotaSourceConnectorConfig(map);
	}

	@Override
	public Class<? extends Task> taskClass() {
		return DotaSourceTask.class;
	}

	@Override
	public List<Map<String, String>> taskConfigs(int count) {
		List<Map<String, String>> configs = new ArrayList<>();

		configs.add(this.settings);

		return configs;
	}

	@Override
	public void stop() {
	}

	@Override
	public ConfigDef config() {
		return DotaSourceConnectorConfig.conf();
	}
}