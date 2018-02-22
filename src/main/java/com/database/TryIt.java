package com.database;

public class TryIt {
public static void main(String[] args) {
	Regexx r=new Regexx();
	System.out.println(r.find("21008-11-12", "[0-9]{4}[-//][01]?[0-9][-//][0-3][0-9]"));
}
}
