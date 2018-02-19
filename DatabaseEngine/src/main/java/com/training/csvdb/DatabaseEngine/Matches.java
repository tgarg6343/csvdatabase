package com.training.csvdb.DatabaseEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Matches {
	private String id;
	private String season;
	private String city;
	private String date;
	private String team1;
	private String team2;
	private String toss_winner;
	private String toss_decision;
	private String result;
	private String dl_applied;
	private String winner;
	private String win_by_runs;
	private String win_by_wickets;
	private String player_of_match;
	private String venue;
	private String umpire1;
	private String umpire2;
	private ArrayList<String> list;
	public Matches(String row) {
		list=new ArrayList<String>();
		list.addAll(Arrays.asList(row.split(",")));
		Iterator<String> iterator=list.iterator();
		int count=0;
		int y=-1;
		while(iterator.hasNext()) {
			String word=(String)iterator.next();
			if(word.startsWith(" ")) {
				y=count;
			}
			count++;
		}
		if(y!=-1) {
			list.set(y-1,list.get(y-1)+","+list.get(y));
			list.remove(y);
		}
		id=list.get(0);
		season=list.get(1);
		city=list.get(2);
		date=list.get(3);
		team1=list.get(4);
		team2=list.get(5);
		toss_winner=list.get(6);
		toss_decision=list.get(7);
		result=list.get(8);
		dl_applied=list.get(9);
		winner=list.get(10);
		win_by_runs=list.get(11);
		win_by_wickets=list.get(12);
		player_of_match=list.get(13);
		venue=list.get(14);
		umpire1=list.get(15);
		umpire2=list.get(16);
		
	}

	@Override
	public String toString() {
		return "Matches [id=" + id + ", season=" + season + ", city=" + city + ", date=" + date + ", team1=" + team1
				+ ", team2=" + team2 + ", toss_winner=" + toss_winner + ", toss_decision=" + toss_decision + ", result="
				+ result + ", dl_applied=" + dl_applied + ", winner=" + winner + ", win_by_runs=" + win_by_runs
				+ ", win_by_wickets=" + win_by_wickets + ", player_of_match=" + player_of_match + ", venue=" + venue
				+ ", umpire1=" + umpire1 + ", umpire2=" + umpire2 + "]";
	}

	public ArrayList<String> getList() {
		return list;
	}
	
	
}
