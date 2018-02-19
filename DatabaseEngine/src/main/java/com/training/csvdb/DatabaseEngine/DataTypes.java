package com.training.csvdb.DatabaseEngine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataTypes {

	/*public static void main(String[] args) {
		String FILENAME="C:\\Users\\tgarg\\Documents\\workspace-sts-3.9.2.RELEASE\\CHECK\\src\\tar.txt";
		BufferedReader buffer=null;
		FileReader file=null;
		String fileText="";
		try {
			file=new FileReader(FILENAME);
			buffer=new BufferedReader(file);
			
			String temp="";
			while((temp=buffer.readLine())!=null) {
				fileText+=temp;
			}
			
			GetDataTypes types=new GetDataTypes(temp, temp);
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
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
		//System.out.println(fileText);
		
		
	}*/
}
