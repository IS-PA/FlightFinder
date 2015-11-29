package com.github.ispa.flightfinder.utils;


import java.util.Map;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FlightfinderApi {
	private static FlightfinderApi instance = null;
	private static final String baseUrlApi = "http://services.devpgsv.com/flightfinder/api/";
	
	private String subjectType;
	private Integer subject;
	private String property;
	
	private FlightfinderApi() {
		
	}
	
	public static FlightfinderApi getInstance() {
		if (FlightfinderApi.instance == null)
			FlightfinderApi.instance = new FlightfinderApi();
		return FlightfinderApi.instance;
	}
	
	public FlightfinderApi fromSubjectType(String subjectType) {
		this.subjectType = subjectType;
		return this;
	}
	
	public FlightfinderApi getSubject(int subject) {
		this.subject = new Integer(subject);
		return this;
	}
	
	public FlightfinderApi selectProperty(String property) {
		this.property = property;
		return this;
	}
	
	private FlightfinderApi reset() {
		this.subjectType = null; this.subject = null; this.property = null;
		return new FlightfinderApi();
	}
	
	public JsonObject get(JsonObject getParams) {
		String url = buildUrl();
		String response = HttpRequests.excutePost(url, buildParams(getParams));
		if (response == null) {
			return null;
		}
		reset();
		return new JsonParser().parse(response).getAsJsonObject();
	}
	
	public JsonObject get() {
		return get(randomUtils.jOb("{}"));
	}
	
	public JsonObject get(String getParams) {
		return get(randomUtils.jOb(getParams));
	}
	
	private String buildUrl() {
		StringBuilder url = new StringBuilder(baseUrlApi);
		if (this.subjectType != null) {
			url.append(this.subjectType + "/");
			if (this.subject != null) {
				url.append(this.subject + "/");
				if (this.property != null) {
					url.append(this.property + "/");
				}
			}
		}
		return url.toString();
	}
	
	public static String buildParams(JsonObject params) {
		StringBuilder paramsS = new StringBuilder();
		for (Map.Entry<String,JsonElement> entry : params.entrySet()) {
			if (entry.getValue().isJsonPrimitive()) {
				paramsS.append(randomUtils.urlEncode(entry.getKey()) + "=" + randomUtils.urlEncode(entry.getValue().getAsString()) + "&");
			} else {
				paramsS.append(randomUtils.urlEncode(entry.getKey()) + "=" + randomUtils.urlEncode(entry.getValue().toString()) + "&");
			}
		}
		return paramsS.toString();
	}
}
