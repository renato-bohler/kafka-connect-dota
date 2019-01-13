package com.renato.bohler.kafka.connect.dota.api;

import java.util.List;

public class MatchApi {
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
	public Long radiant_team_id;
	public Long dire_team_id;
	public List<PickBansApi> pick_bans;

}
