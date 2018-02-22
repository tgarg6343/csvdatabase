package com.database;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryDetails {
	String fileName;
	String query;
	String basePart;
	String filterPart;
	String orderBy;
	String groupBy;
	String displayString;
	String allFields;
	ArrayList<String> logicalOp;
	ArrayList<String> conditions;
	ArrayList<String> displayFields;
	ArrayList<String> aggregrateFields;
	
	public QueryDetails(String query1) {
		HeaderFields h=new HeaderFields();
		query=trimmer(query1);//removes all extra whitespaces
		String x="where";
		String tokens[]=query.split(" ");
		int fileIndex=h.getIndex(tokens, x)-1;
		
		fileName=tokens[fileIndex];
		System.out.println(fileName);
		basePart=query.substring(0,query.indexOf("from"));//gives base part
		System.out.println(basePart);
		filterPart=query.substring(query.indexOf(x)+x.length()+1);//gives filtered part
		logicalOp=new ArrayList<String>();
		conditions=new ArrayList<String>();
		if(filterPart!=null) {
			String filteredWords[]=filterPart.split(" ");
			int previous=0;
			String condition="";
			for(int i=0;i<filteredWords.length;i++) {
				if(filteredWords[i].equalsIgnoreCase("and")||filteredWords[i].equalsIgnoreCase("or")||filteredWords[i].equalsIgnoreCase("not")) {
					condition="";
					logicalOp.add(filteredWords[i]);
					for(int j=previous;j<i;j++) {
						condition+=filteredWords[j]+" ";
					}
					conditions.add(condition.trim());
					previous=i+1;
				}
			}
			condition="";	
			for(int j=previous;j<filteredWords.length;j++) {
				if(filteredWords[j].equals("order")||filteredWords[j].equals("group")) {
					break;
				}
				condition+=filteredWords[j]+" ";			
			}
			conditions.add(condition.trim());
			groupBy=getGroupBy(filterPart);
			orderBy=getOrderBy(filterPart);
		}
		displayFields=new ArrayList<String>();
		aggregrateFields=new ArrayList<String>();
		allFields=basePart.substring(basePart.indexOf("select")+7);
		String[] fields=allFields.split(",");
	for (int i = 0; i < fields.length; i++) {
		System.out.println(fields[i]);
	}
		boolean selectAll=false;
		if(fields.length==2&&fields[1].equals("*")) {
			selectAll=true;
		}
		for(String field: fields) {
			if(field.equalsIgnoreCase("select"))
				continue;
			else if(field.equalsIgnoreCase("from"))
				break;
			else {
				displayFields.add(field.trim());
				if(field.startsWith("avg")||field.startsWith("min")||field.startsWith("max")||field.startsWith("count")||field.startsWith("sum")) {
					aggregrateFields.add(field.trim());
				}
			}
		}
		
	}
	public String getOrderBy(String filterpart) {
		Pattern pattern=Pattern.compile("order by ([\\w]+)");
		Matcher matcher=pattern.matcher(filterpart);
		if(matcher.find()) {
			String temp=filterpart.substring(matcher.start(),matcher.end());
			return temp.substring(temp.indexOf("by")+3);
		}
		else
			return null;
	}
	private String getGroupBy(String filterpart) {
		Pattern pattern=Pattern.compile("group by ([\\w]+)");
		Matcher matcher=pattern.matcher(filterpart);
		if(matcher.find()) {
			String temp=filterpart.substring(matcher.start(),matcher.end());
			return temp.substring(temp.indexOf("by")+3);
		}
		else
			return null;
	}
	
	public String trimmer(String query) { //method to remove extra whitespaces
		Pattern pattern=Pattern.compile("\\s+");
		Matcher matcher=pattern.matcher(query);
		return matcher.replaceAll(" ").trim();
	}
	@Override
	public String toString() {
		return "QueryDetails [\nquery=" + query + "\n, basePart=" + basePart + "\n, filterPart=" + filterPart + "\n, orderBy="
				+ orderBy + "\n, groupBy=" + groupBy + "\n, logicalOp=" + logicalOp + "\n, conditions=" + conditions
				+ "\n, displayFields=" + displayFields + "\n, aggregrateFields=" + aggregrateFields + "]";
	}
	public void printWords(String[] words) {// method to print words
		for(String word:words) {
			System.out.println(word);
		}
	}
	public String getQuery() {
		return query;
	}
	public String getBasePart() {
		return basePart;
	}
	public String getFilterPart() {
		return filterPart;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public String getGroupBy() {
		return groupBy;
	}
	public ArrayList<String> getLogicalOp() {
		return logicalOp;
	}
	public ArrayList<String> getConditions() {
		return conditions;
	}
	public ArrayList<String> getDisplayFields() {
		return displayFields;
	}
	public ArrayList<String> getAggregrateFields() {
		return aggregrateFields;
	}
	public String getfileName() {
		return fileName;
	}
}