package com.github.ispa.flightfinder.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class randomUtils {
	
	
	public static String buildStringFromChar(char c, int n) {
		return new String(new char[n]).replace('\0', c);
	}
	
	public static JsonObject jOb(String s) {
		JsonObject jo;
		try {
			jo = new JsonParser().parse(s).getAsJsonObject();
		} catch(Exception e){
			jo = new JsonObject();
		}
		return jo;
	}
	public static JsonObject jOb() {
		return jOb("{}");
	}
	
	public static String urlEncode(String s) {
		String en = "";
		try {
			en = URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			en = s;
		}
		return en;
	}
}
