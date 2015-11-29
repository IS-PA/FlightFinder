package com.github.ispa.flightfinder.logic;

import java.util.HashMap;

import com.github.ispa.flightfinder.utils.FlightfinderApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Flights {
	private static Flights instance = null;
	private HashMap<Integer, Flight> flights;
	
	private Flights() {
		this.flights = new HashMap<Integer, Flight>();
		pullFlights();
	}
	
	public static Flights getInstance() {
		if (Flights.instance == null)
			Flights.instance = new Flights();
		return Flights.instance;
	}
	
	public boolean addFlight(Flight flight) {
		int id = flight.getId();
		if (existsFlight(id)) {
			return false;
		} else {
			flights.put(id, flight);
			return true;
		}
	}
	
	public boolean existsFlight(int id) {
		return flights.containsKey(id);
	}
	
	public Flight getFlight(int id) {
		if (!existsFlight(id)) return null;
		return flights.get(id);
	}
	
	
	public void pullFlights() {
		Gson gson = new GsonBuilder().registerTypeAdapter(Flight.class, new FlightDeserializer()).create();
		FlightfinderApi api = FlightfinderApi.getInstance();
		System.out.print("Loading flights.... ");
		JsonObject response = api.fromSubjectType("flights").get();
		if (response.get("status").getAsString().equals("ok") && response.get("request").isJsonArray()) {
			for(JsonElement flight : response.get("request").getAsJsonArray()) {
				addFlight(gson.fromJson(flight, Flight.class));
			}
		} else {
			System.out.println(response.toString());
			System.exit(1);
		}
		System.out.println("Loaded!");
	}
}
