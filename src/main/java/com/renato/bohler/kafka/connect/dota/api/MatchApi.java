package com.renato.bohler.kafka.connect.dota.api;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class MatchApi extends Struct {
	public MatchApi() {
		super(schema);
	}

	public MatchApi(Schema schema) {
		super(schema);
	}

	public List<PlayerApi> players;
	public Boolean radiant_win;
	public Long duration;
	public Long pre_game_duration;
	public Long start_time;
	public Long match_id;
	public Long match_seq_num;
	public Long tower_status_radiant;
	public Long tower_status_dire;
	public Long barracks_status_radiant;
	public Long barracks_status_dire;
	public Long cluster;
	public Long first_blood_time;
	public Long lobby_type;
	public Long human_players;
	public Long leagueid;
	public Long positive_votes;
	public Long negative_votes;
	public Long game_mode;
	public Long flags;
	public Long engine;
	public Long radiant_score;
	public Long dire_score;
	public Long radiant_captain;
	public Long dire_captain;
	public Long radiant_team_id;
	public Long dire_team_id;
	public String radiant_name;
	public String dire_name;
	public String radiant_logo;
	public String dire_logo;
	public Long radiant_team_complete;
	public Long dire_team_complete;
	public List<PickBansApi> picks_bans;

	private static Schema schema = SchemaBuilder.struct().name("com.renato.bohler.kafka.connect.dota.api.MatchApi")
			.field("players", SchemaBuilder.array(PlayerApi.getSchema()).optional())
			.field("radiant_win", Schema.OPTIONAL_BOOLEAN_SCHEMA).field("duration", Schema.OPTIONAL_INT64_SCHEMA)
			.field("pre_game_duration", Schema.OPTIONAL_INT64_SCHEMA).field("start_time", Schema.OPTIONAL_INT64_SCHEMA)
			.field("match_id", Schema.OPTIONAL_INT64_SCHEMA).field("match_seq_num", Schema.OPTIONAL_INT64_SCHEMA)
			.field("tower_status_radiant", Schema.OPTIONAL_INT64_SCHEMA)
			.field("tower_status_dire", Schema.OPTIONAL_INT64_SCHEMA)
			.field("barracks_status_radiant", Schema.OPTIONAL_INT64_SCHEMA)
			.field("barracks_status_dire", Schema.OPTIONAL_INT64_SCHEMA).field("cluster", Schema.OPTIONAL_INT64_SCHEMA)
			.field("first_blood_time", Schema.OPTIONAL_INT64_SCHEMA).field("lobby_type", Schema.OPTIONAL_INT64_SCHEMA)
			.field("human_players", Schema.OPTIONAL_INT64_SCHEMA).field("leagueid", Schema.OPTIONAL_INT64_SCHEMA)
			.field("positive_votes", Schema.OPTIONAL_INT64_SCHEMA).field("negative_votes", Schema.OPTIONAL_INT64_SCHEMA)
			.field("game_mode", Schema.OPTIONAL_INT64_SCHEMA).field("flags", Schema.OPTIONAL_INT64_SCHEMA)
			.field("engine", Schema.OPTIONAL_INT64_SCHEMA).field("radiant_score", Schema.OPTIONAL_INT64_SCHEMA)
			.field("dire_score", Schema.OPTIONAL_INT64_SCHEMA).field("radiant_captain", Schema.OPTIONAL_INT64_SCHEMA)
			.field("dire_captain", Schema.OPTIONAL_INT64_SCHEMA).field("radiant_team_id", Schema.OPTIONAL_INT64_SCHEMA)
			.field("dire_team_id", Schema.OPTIONAL_INT64_SCHEMA).field("radiant_name", Schema.OPTIONAL_STRING_SCHEMA)
			.field("dire_name", Schema.OPTIONAL_STRING_SCHEMA).field("radiant_logo", Schema.OPTIONAL_STRING_SCHEMA)
			.field("dire_logo", Schema.OPTIONAL_STRING_SCHEMA)
			.field("radiant_team_complete", Schema.OPTIONAL_INT64_SCHEMA)
			.field("dire_team_complete", Schema.OPTIONAL_INT64_SCHEMA)
			.field("picks_bans", SchemaBuilder.array(PickBansApi.getSchema()).optional()).build();

	public static Schema getSchema() {
		return schema;
	}

	public Struct getStruct() {
		List<Struct> players = this.players != null
				? this.players.stream().map(PlayerApi::getStruct).collect(Collectors.toList())
				: null;
		List<Struct> picks_bans = this.picks_bans != null
				? this.picks_bans.stream().map(PickBansApi::getStruct).collect(Collectors.toList())
				: null;

		return new Struct(MatchApi.getSchema()).put("players", players).put("radiant_win", this.radiant_win)
				.put("duration", this.duration).put("pre_game_duration", this.pre_game_duration)
				.put("start_time", this.start_time).put("match_id", this.match_id)
				.put("match_seq_num", this.match_seq_num).put("tower_status_radiant", this.tower_status_radiant)
				.put("tower_status_dire", this.tower_status_dire)
				.put("barracks_status_radiant", this.barracks_status_radiant)
				.put("barracks_status_dire", this.barracks_status_dire).put("cluster", this.cluster)
				.put("first_blood_time", this.first_blood_time).put("lobby_type", this.lobby_type)
				.put("human_players", this.human_players).put("leagueid", this.leagueid)
				.put("positive_votes", this.positive_votes).put("negative_votes", this.negative_votes)
				.put("game_mode", this.game_mode).put("flags", this.flags).put("engine", this.engine)
				.put("radiant_score", this.radiant_score).put("dire_score", this.dire_score)
				.put("radiant_captain", this.radiant_captain).put("dire_captain", this.dire_captain)
				.put("radiant_team_id", this.radiant_team_id).put("dire_team_id", this.dire_team_id)
				.put("radiant_name", this.radiant_name).put("dire_name", this.dire_name)
				.put("radiant_logo", this.radiant_logo).put("dire_logo", this.dire_logo)
				.put("radiant_team_complete", this.radiant_team_complete)
				.put("dire_team_complete", this.dire_team_complete).put("picks_bans", picks_bans);
	}

}
