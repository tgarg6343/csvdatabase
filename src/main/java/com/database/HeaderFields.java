package com.database;


public class HeaderFields {
	static Regexx r=null;
	public int getIndex(String[] fields,String x) {
		for (int i = 0; i < fields.length; i++) {
			if(fields[i].equalsIgnoreCase(x)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	public static String[] splitWhere(String condition) {
		r=new Regexx();
		String[] tokens=new String[3];
		String x=r.regex(condition,"[=><]");
		
		String testField=condition.substring(0, condition.indexOf(x));
		String testvalue=condition.substring(condition.indexOf(x)+1);
		tokens[0]=testField;
		tokens[1]=x;
		tokens[2]=r.regex(testvalue, "([\\w]+)");
		System.out.println(x);
		System.out.println(testField);
		System.out.println(testvalue);
		
		return tokens;
	}
}