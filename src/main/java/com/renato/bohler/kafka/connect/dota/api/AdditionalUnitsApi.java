package com.renato.bohler.kafka.connect.dota.api;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class AdditionalUnitsApi extends Struct {
	public AdditionalUnitsApi() {
		super(schema);
	}

	public AdditionalUnitsApi(Schema schema) {
		super(schema);
	}

	public String unitname;
	public Long item_0;
	public Long item_1;
	public Long item_2;
	public Long item_3;
	public Long item_4;
	public Long item_5;
	public Long backpack_0;
	public Long backpack_1;
	public Long backpack_2;

	private static Schema schema = SchemaBuilder.struct()
			.name("com.renato.bohler.kafka.connect.dota.api.AdditionalUnitsApi")
			.field("unitname", Schema.OPTIONAL_STRING_SCHEMA).field("item_0", Schema.OPTIONAL_INT64_SCHEMA)
			.field("item_1", Schema.OPTIONAL_INT64_SCHEMA).field("item_2", Schema.OPTIONAL_INT64_SCHEMA)
			.field("item_3", Schema.OPTIONAL_INT64_SCHEMA).field("item_4", Schema.OPTIONAL_INT64_SCHEMA)
			.field("item_5", Schema.OPTIONAL_INT64_SCHEMA).field("backpack_0", Schema.OPTIONAL_INT64_SCHEMA)
			.field("backpack_1", Schema.OPTIONAL_INT64_SCHEMA).field("backpack_2", Schema.OPTIONAL_INT64_SCHEMA)
			.build();

	public static Schema getSchema() {
		return schema;
	}

	public Struct getStruct() {
		return new Struct(AdditionalUnitsApi.getSchema()).put("unitname", this.unitname).put("item_0", this.item_0)
				.put("item_1", this.item_1).put("item_2", this.item_2).put("item_3", this.item_3)
				.put("item_4", this.item_4).put("item_5", this.item_5).put("backpack_0", this.backpack_0)
				.put("backpack_1", this.backpack_1).put("backpack_2", this.backpack_2);
	}

}
