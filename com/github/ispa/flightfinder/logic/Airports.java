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
	
	public boolean addAirport(Airport airport) {
		int id = airport.getId();
		if (existsAirport(id)) {
			return false;
		} else {
			airports.put(id, airport);
			return true;
		}
	}
	
	public boolean existsAirport(int id) {
		return airports.containsKey(id);
	}
	
	public Airport getAirport(int id) {
		if (!existsAirport(id)) return null;
		return airports.get(id);
	}
	
	public void pullAirports() {
		Gson gson = new Gson();
		FlightfinderApi api = FlightfinderApi.getInstance();
		System.out.print("Loading airports... ");
		JsonObject response = api.fromSubjectType("airports").get();
		if (response.get("status").getAsString().equals("ok") && response.get("request").isJsonArray()) {
			for(JsonElement airport : response.get("request").getAsJsonArray()) {
				addAirport(gson.fromJson(airport, Airport.class));
			}
		} else {
			System.out.println(response.toString());
			System.exit(1);
		}
		System.out.println("Loaded!");
	}
}
