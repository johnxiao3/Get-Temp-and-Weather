package com.Weather;

import java.io.*;
import java.net.*;

import org.json.JSONObject;

public class Weather {

   private static final String JSONSerializer = null;

public static String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString();
   }

   public static void main(String[] args) throws Exception
   {
	  String a="https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%27lincoln%27)%20and%20u=%27c%27&format=json";
      String b=null;
      Weather w=new Weather();
      String temperature=null;
      b=Weather.getHTML(a);
      //System.out.println(b);
      JSONObject json = new JSONObject(b);
      String temp1=json.getJSONObject("query")
    		  .getJSONObject("results")
    		  .getJSONObject("channel")
    		  .getJSONObject("item")
    		  .getJSONObject("condition")
    		  .getString("temp");
      String weath1=json.getJSONObject("query")
    		  .getJSONObject("results")
    		  .getJSONObject("channel")
    		  .getJSONObject("item")
    		  .getJSONObject("condition")
    		  .getString("text");
      
     	  
      System.out.println(temp1);
      System.out.println(weath1);
   }
}
