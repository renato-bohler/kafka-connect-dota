package com.renato.bohler.kafka.connect.dota;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

public class DotaSourceConnectorConfig extends AbstractConfig {

	public static final String MATCHES_TOPIC_CONFIG = "matches.topic";
	private static final String MATCHES_TOPIC_DOC = "Kafka topic to write matches to";

	public static final String WEBAPI_KEY_CONFIG = "webapi.key";
	private static final String WEBAPI_KEY_DOC = "Key for the DotA 2 WebAPI";

	public static final String RATE_LIMIT_MS_CONFIG = "rate.limit.ms";
	private static final String RATE_LIMIT_MS_DOC = "Rate (in ms) to poll DotA 2 WebAPI";

	public final String matchesTopic;
	public final String webApiKey;
	public final Long rateLimitMs;

	public DotaSourceConnectorConfig(Map<String, String> parsedConfig) {
		super(conf(), parsedConfig);
		this.matchesTopic = getString(MATCHES_TOPIC_CONFIG);
		this.webApiKey = getString(WEBAPI_KEY_CONFIG);
		this.rateLimitMs = getLong(RATE_LIMIT_MS_CONFIG);
	}

	public static ConfigDef conf() {
		return new ConfigDef().define(MATCHES_TOPIC_CONFIG, Type.STRING, Importance.HIGH, MATCHES_TOPIC_DOC)
				.define(WEBAPI_KEY_CONFIG, Type.STRING, Importance.HIGH, WEBAPI_KEY_DOC).define(RATE_LIMIT_MS_CONFIG,
						Type.LONG, 1500, ConfigDef.Range.atLeast(1000), Importance.MEDIUM, RATE_LIMIT_MS_DOC);
	}
}