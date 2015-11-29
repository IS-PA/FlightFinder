package com.github.ispa.flightfinder.examples;

import com.github.ispa.flightfinder.utils.HttpRequests;
import com.github.ispa.flightfinder.utils.randomUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class http {

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		String t;
		
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests");
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests", "a=b&c=d");
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests", "a=b&c=d","e=f");
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests", "","e=f");
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests", "", "a=b&c=d");
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests/testId1");
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests/testId1/option2");
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/tests/testId1/option3", "", "action=update&newValue=whatever"); // Just an example. Nothing happens.
		System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		//t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/flight/1/origin", "", "action=update&newValue=2"); // Just an example. Nothing happens.
		//System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		t = HttpRequests.excutePost("http://services.devpgsv.com/flightfinder/srthrhe"); // This url doesn't exist
		if (! (t == null)) {
			System.out.println(gson.toJson(jp.parse(t)) + "\n" + randomUtils.buildStringFromChar('-', 30));
		} else {
			System.out.println("Couldn't send request" + "\n" + randomUtils.buildStringFromChar('-', 30));
		}
	}

}
