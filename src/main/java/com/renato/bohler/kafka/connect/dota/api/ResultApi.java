package com.renato.bohler.kafka.connect.dota.api;

import java.util.List;

public class ResultApi {
	public Long status;
	public Long num_results;
	public Long total_results;
	public Long results_remaining;
	public List<MatchApi> matches;

}
