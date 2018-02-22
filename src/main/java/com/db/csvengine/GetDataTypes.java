package com.db.csvengine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GetDataTypes {
	Map<String,String> map=null;
	Regexx r=null;
	public GetDataTypes(String header,String valueRow) {
		/*System.out.println(header);
		System.out.println(valueRow);*/
		String headersList[]=valueRow.split(",");//splitting header fields
		map=new LinkedHashMap<String,String>();
		for(String field:headersList){
			try {
				int x=Integer.parseInt(field);
				map.put(field, "Integer");
			}
			catch(NumberFormatException e){
				r=new Regexx();
				if(r.find(field, "[0-9]{4}[-//][01]?[0-9][-//][0-3][0-9]")) {	
					map.put(field, "Date");
				}
			else
				map.put(field, "String");
				
			}
		}
	}
	public void print() {
		Set<String> keys=map.keySet();
		Iterator<String> iterator=keys.iterator();
		while(iterator.hasNext()) {
			String key=(String)iterator.next();
			System.out.println("key:"+key+" value: "+map.get(key));
		}	
	}
	public Map<String, String> getMap() {
		return map;
	}
}