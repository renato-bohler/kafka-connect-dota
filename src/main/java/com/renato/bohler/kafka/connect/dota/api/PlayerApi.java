package com.renato.bohler.kafka.connect.dota.api;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class PlayerApi extends Struct {
	public PlayerApi() {
		super(schema);
	}

	public PlayerApi(Schema schema) {
		super(schema);
	}

	public Long account_id;
	public Long player_slot;
	public Long hero_id;
	public Long item_0;
	public Long item_1;
	public Long item_2;
	public Long item_3;
	public Long item_4;
	public Long item_5;
	public Long backpack_0;
	public Long backpack_1;
	public Long backpack_2;
	public Long kills;
	public Long deaths;
	public Long assists;
	public Long leaver_status;
	public Long last_hits;
	public Long denies;
	public Long gold_per_min;
	public Long xp_per_min;
	public Long level;
	public Long hero_damage;
	public Long tower_damage;
	public Long hero_healing;
	public Long gold;
	public Long gold_spent;
	public Long scaled_hero_damage;
	public Long scaled_tower_damage;
	public Long scaled_hero_healing;
	public List<AbilityUpgradesApi> ability_upgrades;
	public List<AdditionalUnitsApi> additional_units;

	private static Schema schema = SchemaBuilder.struct().name("com.renato.bohler.kafka.connect.dota.api.PlayerApi")
			.field("account_id", Schema.OPTIONAL_INT64_SCHEMA).field("player_slot", Schema.OPTIONAL_INT64_SCHEMA)
			.field("hero_id", Schema.OPTIONAL_INT64_SCHEMA).field("item_0", Schema.OPTIONAL_INT64_SCHEMA)
			.field("item_1", Schema.OPTIONAL_INT64_SCHEMA).field("item_2", Schema.OPTIONAL_INT64_SCHEMA)
			.field("item_3", Schema.OPTIONAL_INT64_SCHEMA).field("item_4", Schema.OPTIONAL_INT64_SCHEMA)
			.field("item_5", Schema.OPTIONAL_INT64_SCHEMA).field("backpack_0", Schema.OPTIONAL_INT64_SCHEMA)
			.field("backpack_1", Schema.OPTIONAL_INT64_SCHEMA).field("backpack_2", Schema.OPTIONAL_INT64_SCHEMA)
			.field("kills", Schema.OPTIONAL_INT64_SCHEMA).field("deaths", Schema.OPTIONAL_INT64_SCHEMA)
			.field("assists", Schema.OPTIONAL_INT64_SCHEMA).field("leaver_status", Schema.OPTIONAL_INT64_SCHEMA)
			.field("last_hits", Schema.OPTIONAL_INT64_SCHEMA).field("denies", Schema.OPTIONAL_INT64_SCHEMA)
			.field("gold_per_min", Schema.OPTIONAL_INT64_SCHEMA).field("xp_per_min", Schema.OPTIONAL_INT64_SCHEMA)
			.field("level", Schema.OPTIONAL_INT64_SCHEMA).field("hero_damage", Schema.OPTIONAL_INT64_SCHEMA)
			.field("tower_damage", Schema.OPTIONAL_INT64_SCHEMA).field("hero_healing", Schema.OPTIONAL_INT64_SCHEMA)
			.field("gold", Schema.OPTIONAL_INT64_SCHEMA).field("gold_spent", Schema.OPTIONAL_INT64_SCHEMA)
			.field("scaled_hero_damage", Schema.OPTIONAL_INT64_SCHEMA)
			.field("scaled_tower_damage", Schema.OPTIONAL_INT64_SCHEMA)
			.field("scaled_hero_healing", Schema.OPTIONAL_INT64_SCHEMA)
			.field("ability_upgrades", SchemaBuilder.array(AbilityUpgradesApi.getSchema()).optional())
			.field("additional_units", SchemaBuilder.array(AdditionalUnitsApi.getSchema()).optional()).build();

	public static Schema getSchema() {
		return schema;
	}

	public Struct getStruct() {
		List<Struct> ability_upgrades = this.ability_upgrades != null
				? this.ability_upgrades.stream().map(AbilityUpgradesApi::getStruct).collect(Collectors.toList())
				: null;
		List<Struct> additional_units = this.additional_units != null
				? this.additional_units.stream().map(AdditionalUnitsApi::getStruct).collect(Collectors.toList())
				: null;

		return new Struct(PlayerApi.getSchema()).put("account_id", this.account_id).put("player_slot", this.player_slot)
				.put("hero_id", this.hero_id).put("item_0", this.item_0).put("item_1", this.item_1)
				.put("item_2", this.item_2).put("item_3", this.item_3).put("item_4", this.item_4)
				.put("item_5", this.item_5).put("backpack_0", this.backpack_0).put("backpack_1", this.backpack_1)
				.put("backpack_2", this.backpack_2).put("kills", this.kills).put("deaths", this.deaths)
				.put("assists", this.assists).put("leaver_status", this.leaver_status).put("last_hits", this.last_hits)
				.put("denies", this.denies).put("gold_per_min", this.gold_per_min).put("xp_per_min", this.xp_per_min)
				.put("level", this.level).put("hero_damage", this.hero_damage).put("tower_damage", this.tower_damage)
				.put("hero_healing", this.hero_healing).put("gold", this.gold).put("gold_spent", this.gold_spent)
				.put("scaled_hero_damage", this.scaled_hero_damage).put("scaled_tower_damage", this.scaled_tower_damage)
				.put("scaled_hero_healing", this.scaled_hero_healing).put("ability_upgrades", ability_upgrades)
				.put("additional_units", additional_units);
	}

}
