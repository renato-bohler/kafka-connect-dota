package com.renato.bohler.kafka.connect.dota.api;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class AbilityUpgradesApi extends Struct {
	public AbilityUpgradesApi() {
		super(schema);
	}

	public AbilityUpgradesApi(Schema schema) {
		super(schema);
	}

	public Long ability;
	public Long time;
	public Long level;

	private static Schema schema = SchemaBuilder.struct()
			.name("com.renato.bohler.kafka.connect.dota.api.AbilityUpgradesApi")
			.field("ability", Schema.OPTIONAL_INT64_SCHEMA).field("time", Schema.OPTIONAL_INT64_SCHEMA)
			.field("level", Schema.OPTIONAL_INT64_SCHEMA).build();

	public static Schema getSchema() {
		return schema;
	}

	public Struct getStruct() {
		return new Struct(AbilityUpgradesApi.getSchema()).put("ability", this.ability).put("time", this.time)
				.put("level", this.level);
	}

}
