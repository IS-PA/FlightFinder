package com.github.ispa.flightfinder.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequests {
	
	public static String excutePost(String targetURL) {
		return excutePost(targetURL, "", "");
	}
	
	public static String excutePost(String targetURL, String getparameters) {
		return excutePost(targetURL, getparameters, "");
	}
	/**
	 * From: http://stackoverflow.com/a/1359700
	 * @param targetURL
	 * @param getparameters
	 * @param postParameters
	 * @return
	 */
	public static String excutePost(String targetURL, String getparameters, String postParameters) {
		if (!(getparameters == null || getparameters.isEmpty())) targetURL = targetURL + "?" +getparameters;
		  HttpURLConnection connection = null;
		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("POST");
		    connection.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");

		    connection.setRequestProperty("Content-Length", 
		        Integer.toString(postParameters.getBytes().length));
		    connection.setRequestProperty("Content-Language", "en-US");  

		    connection.setUseCaches(false);
		    connection.setDoOutput(true);

		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		        connection.getOutputStream());
		    wr.writeBytes(postParameters);
		    wr.close();

		    //Get Response  
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+ 
		    String line;
		    while((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if(connection != null) {
		      connection.disconnect(); 
		    }
		  }
		}
}
