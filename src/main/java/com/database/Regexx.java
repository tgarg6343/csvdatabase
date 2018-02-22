package com.database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexx {
	public String regex(String s,String regex) {
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(s);
		if(matcher.find()) {
			String temp=s.substring(matcher.start(),matcher.end());
			return temp;
		}
		else 
			return null;
	}
	public boolean find(String s,String regex) {
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(s);
		return matcher.find();
	}
}