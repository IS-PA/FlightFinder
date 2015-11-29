package com.github.ispa.flightfinder.examples;

import com.github.ispa.flightfinder.utils.randomUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@SuppressWarnings("unused")
public class json {

	public static void main(String[] args) {
		JsonObject o;
		test();
	}
	
	public static void test() {
		String t = "{\"var1\":\"val1\", \"var2\":{\"var2.1\":\"val2.1\",\"var2.2\":\"val2.2\"}}";
		Gson prettyJsonPrinter = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(t);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		// Print the string as it is
		System.out.println("String:\n" + t + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		// This prints the structure of a JsonElement
		System.out.println("Object:\n" + prettyJsonPrinter.toJson(jsonElement)  + "\n" + randomUtils.buildStringFromChar('-', 30));
		
		
		// We try to access the value of "var1"
		if (jsonObject.has("var1")) {
			System.out.println("var1: " + jsonObject.get("var1").getAsString()  + "\n" + randomUtils.buildStringFromChar('-', 30));
		}
		
		// We try to access the value of "var2.1"
		if (jsonObject.has("var2")) {
			if (jsonObject.getAsJsonObject("var2").has("var2.1")) {
				System.out.println("var2 -> var2.1: " + jsonObject.getAsJsonObject("var2").get("var2.1").getAsString()  + "\n" + randomUtils.buildStringFromChar('-', 30));
			}
		}
	}
}
