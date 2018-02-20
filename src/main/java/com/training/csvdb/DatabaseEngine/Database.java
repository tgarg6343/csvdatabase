package com.training.csvdb.DatabaseEngine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Database {
	/*public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String query=scan.nextLine();
		HeaderFields h=new HeaderFields();
		QueryDetails q=new QueryDetails(query);
		FileReader file=null;
		BufferedReader buffer=null;
		Matches[] match=new Matches[577];
		String headersList[]=null;
		try {
	    	file=new FileReader(q.getfileName());
	    	buffer = new BufferedReader(file);
	    	String st;
	    	int x=0;
	    	while ((st = buffer.readLine()) != null) {
	    		if(x==0) {
	    			headersList=st.split(",");
	    			x++;
	    		}else {
	    			match[x-1]=new Matches(st);
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
		for (Matches matches : match) {
			System.out.println(matches);
		} 
		ArrayList<Integer> indexes=new ArrayList<Integer>();
		String[] fieldText=q.allFields.trim().split(",");
		for (int i = 0; i < fieldText.length; i++) {
			indexes.add(h.getIndex(headersList, fieldText[i]));
		}
		
		String condition=q.getConditions().get(0).trim();
		//System.out.println(condition);
		//System.out.println(indexes);
		Regexx r=new Regexx();
		String [] tokens=HeaderFields.splitWhere(condition);//tokenizing where condition
		
		
		
		
		ArrayList<Matches> matchList=new ArrayList<Matches>();
		matchList.addAll(Arrays.asList(match));
		Iterator<Matches> i=matchList.iterator();
		while(i.hasNext()) {
			Matches match1=(Matches)i.next();
			Iterator<Integer> i2=indexes.iterator();
			while(i2.hasNext()) {
				//System.out.print(match1.getList().get((Integer)i2.next())+" ");
			}
			System.out.println();
		}
		
		
		//Stream<Matches> matches=Stream.of(match);	
	}*/
}
