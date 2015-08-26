package com.ca.field.json;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, JSONException {
		// TODO Auto-generated method stub
        JSONArray a;
        JSONObject j;
        JSONStringer jj;
        Object o;
        String s;
        String jString = "";
        String file="resources\\books.json";

        // read .json file to fill up jString (holding the json we want to test)
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
            	jString += line;
            }
        }
        System.out.println("Done filling jString - "+jString);
        
        j = new JSONObject(jString);
        Double price=(double) 0;
        String title = null;
        
        JSONObject store = (JSONObject) j.get("store");
        JSONArray books = (JSONArray) store.get("book");
        JSONObject book;
        System.out.println("Number of books="+books.length());
        for(int i=0;i<books.length();i++)
        {
            book = (JSONObject) books.get(i);
        	price = (Double) book.get("price");
        	title = (String) book.get("title");
        	System.out.println("Book title \""+title+"\" costs "+price.toString()+" Euro");
        	
        }
   /*     
        JSONObject bicycle = (JSONObject) store.get("bicycle");
        price = (Double) bicycle.get("price");
        
        System.out.println("Price = "+price);
        */
	}
	
}
