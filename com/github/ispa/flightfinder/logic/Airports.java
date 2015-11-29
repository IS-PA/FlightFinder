package com.github.ispa.flightfinder.logic;

import java.util.HashMap;

import com.github.ispa.flightfinder.utils.FlightfinderApi;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public final class Airports {
	private static Airports instance = null;
	private HashMap<Integer, Airport> airports;
	
	private Airports() {
		this.airports = new HashMap<Integer, Airport>();
		pullAirports();
	}
	
	public static Airports getInstance() {
		if (Airports.instance == null)
			Airports.instance = new Airports();
		return Airports.instance;
	}
	
	private boolean addAirportLocal(Airport airport) {
		int id = airport.getId();
		if (existsAirport(id)) {
			return false;
		} else {
			airports.put(id, airport);
			return true;
		}
	}
	
	private void deleteAirportLocal(int i) {
		airports.remove(i);
	}
	
	public boolean existsAirport(int id) {
		return airports.containsKey(id);
	}
	
	public Airport getAirport(int id) {
		if (!existsAirport(id)) return airports.get(0);
		return airports.get(id);
	}
	
	public void pullAirports() {
		this.airports.clear();
		Gson gson = new Gson();
		FlightfinderApi api = FlightfinderApi.getInstance();
		System.out.print("Loading airports... ");
		JsonObject response = api.fromSubjectType("airports").get();
		if (response.get("status").getAsString().equals("ok") && response.get("request").isJsonArray()) {
			for(JsonElement airport : response.get("request").getAsJsonArray()) {
				addAirportLocal(gson.fromJson(airport, Airport.class));
			}
		} else {
			System.out.println(response.toString());
			System.exit(1);
		}
		System.out.println("Loaded!");
	}
	
	public void pullAirport(int id) {
		Gson gson = new Gson();
		FlightfinderApi api = FlightfinderApi.getInstance();
		JsonObject response = api.fromSubjectType("airport").getSubject(id).get();
		if (response.get("status").getAsString().equals("ok")) {
			addAirportLocal(gson.fromJson(response.get("request").getAsJsonObject(), Airport.class));
		}
	}
	
	public int addAirport(Airport airport) {
		Gson gson = new Gson();
		FlightfinderApi api = FlightfinderApi.getInstance();
		JsonObject response = api.fromSubjectType("airports").add(gson.toJsonTree(airport).getAsJsonObject());
		if (response.get("status").getAsString().equals("ok")) {
			pullAirport(response.get("request").getAsInt());
			return response.get("request").getAsInt();
		}
		return -1;
	}

	public boolean deleteAirport(int i) {
		FlightfinderApi api = FlightfinderApi.getInstance();
		JsonObject response = api.fromSubjectType("airports").delete(i);
		if (response.get("status").getAsString().equals("ok")) {
			deleteAirportLocal(i);
			return true;
		}
		return false;
	}
}
