package com.training.csvdb.DatabaseEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GetDataTypes {
public GetDataTypes(String header,String valueRow) {
	System.out.println(header);
	System.out.println(valueRow);
	
	//String headers[]=header.split("\\s*,\\s*");
	
	/*for(String header1:headers)
		System.out.println(header);
	*/
	String headers1[]=valueRow.split(",");
	char[] dataTypes=new char[17];
	
	Map<String,String> map=new LinkedHashMap<String,String>();
	for(String header1:headers1){
		try {
			int x=Integer.parseInt(header1);
			map.put(header1, "Integer");
		}
		catch(NumberFormatException e){
			map.put(header1, "String");
		}
	}
	
	Set<String> keys=map.keySet();
	Iterator<String> iterator=keys.iterator();
	
	while(iterator.hasNext()) {
		String key=(String)iterator.next();
		System.out.println("key:"+key+" value: "+map.get(key));
	}
	
}
}
