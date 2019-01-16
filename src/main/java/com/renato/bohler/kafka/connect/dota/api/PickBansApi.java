package com.renato.bohler.kafka.connect.dota.api;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class PickBansApi extends Struct {
	public PickBansApi() {
		super(schema);
	}

	public PickBansApi(Schema schema) {
		super(schema);
	}

	public Boolean is_pick;
	public Long hero_id;
	public Long team;
	public Long order;

	private static Schema schema = SchemaBuilder.struct().name("com.renato.bohler.kafka.connect.dota.api.PickBansApi")
			.field("is_pick", Schema.OPTIONAL_BOOLEAN_SCHEMA).field("hero_id", Schema.OPTIONAL_INT64_SCHEMA)
			.field("team", Schema.OPTIONAL_INT64_SCHEMA).field("order", Schema.OPTIONAL_INT64_SCHEMA).build();

	public static Schema getSchema() {
		return schema;
	}

	public Struct getStruct() {
		return new Struct(PickBansApi.getSchema()).put("is_pick", this.is_pick).put("hero_id", this.hero_id)
				.put("team", this.team).put("order", this.order);
	}

}
