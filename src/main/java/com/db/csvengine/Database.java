package com.db.csvengine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Database {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String query=scan.nextLine();
		HeaderFields h=new HeaderFields();
		GetDataTypes dataType=null;
		QueryDetails q=new QueryDetails(query);
		FileReader file=null;
		BufferedReader buffer=null;
		Matches[] match=new Matches[577];
		String header=null;
		String valueRow=null;
		String headersList[]=null;
		try {
	    	file=new FileReader(q.getfileName());
	    	buffer = new BufferedReader(file);
	    	String readLineByLine;
	    	int x=0;
	    	while ((readLineByLine = buffer.readLine()) != null) {
	    		if(x==0) {
	    			header=readLineByLine;
	    			headersList=readLineByLine.split(",");
	    			x++;
	    		}else {
	    			if(x==1)
	    				valueRow=readLineByLine;
	    			match[x-1]=new Matches(readLineByLine);
	    			x++;
	    		}
	    	}
	    }	
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(file!=null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(buffer!=null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		ArrayList<Integer> indexes=new ArrayList<Integer>();
		String[] fieldText=q.allFields.trim().split(",");
		for (int i = 0; i < fieldText.length; i++) {
			indexes.add(h.getIndex(headersList, fieldText[i]));
		}
		
		String condition=q.getConditions().get(0).trim();
		Regexx r=new Regexx();
		String x=r.regex(condition,"[=><]");
		
		String testField=condition.substring(0, condition.indexOf(x));
		String testvalue=condition.substring(condition.indexOf(x)+1);
		String [] tokens=HeaderFields.splitWhere(condition);
		
		String value=r.regex(testvalue, "([\\w]+)");
		System.out.println(testField);
		System.out.println(testvalue);
		System.out.println(value);
		int field=h.getIndex(headersList, testField);
		
		dataType=new GetDataTypes(header, valueRow);
		Map<String,String> map=dataType.getMap();
		
		Stream<Matches> stream=null;
		if(x.equals("=")) {
			if(map.get(testField).equalsIgnoreCase("String")&&x.equals("="))
				stream=Stream.of(match).filter((match1)-> match1.getList().get(field).equalsIgnoreCase(value));	
			else {
				stream=Stream.of(match).filter((match1)-> match1.getList().get(field).equals(testvalue));
			}
		}
		else if(x.equals(">"))
			stream=Stream.of(match).filter((match1)-> Integer.parseInt(match1.getList().get(field))>Integer.parseInt(testvalue));
		else if(x.equals("<"))
			stream=Stream.of(match).filter((match1)-> Integer.parseInt(match1.getList().get(field))>Integer.parseInt(testvalue));
		else if(x.equals(">="))
			stream=Stream.of(match).filter((match1)-> Integer.parseInt(match1.getList().get(field))>Integer.parseInt(testvalue));
		else if(x.equals("<="))
			stream=Stream.of(match).filter((match1)-> Integer.parseInt(match1.getList().get(field))>Integer.parseInt(testvalue));
		
		ArrayList<Matches> matchList=new ArrayList<Matches>();
		matchList.addAll(Arrays.asList(match));
		Iterator<Matches> i=stream.iterator();
		while(i.hasNext()) {
			Matches match1=(Matches)i.next();
			Iterator<Integer> i2=indexes.iterator();
			while(i2.hasNext()) {
				System.out.print(match1.getList().get((Integer)i2.next())+"   ");
			}
			System.out.println();
		}
		
		
		//Stream<Matches> matches=Stream.of(match);	
	}
}