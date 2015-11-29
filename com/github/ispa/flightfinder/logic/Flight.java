package com.github.ispa.flightfinder.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Flight {
	private int id;
	private Airport origin;
	private Airport destination;
	private int departure_timestamp;
	private JsonObject seats;
	
	public Flight(int id, Airport origin, Airport destination, int departure_timestamp) {
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.departure_timestamp = departure_timestamp;
	}

	public int getId() {
		return this.id;
	}
	
	public Airport getOrigin() {
		return this.origin;
	}
	
	public Airport getDestination() {
		return this.destination;
	}
	
	public int getDepartureTimestamp() {
		return this.departure_timestamp;
	}

	public JsonObject getSeats() {
		return this.seats;
	}
	
	public JsonObject toJsonObject() {
		Gson gson = new GsonBuilder().registerTypeAdapter(Flight.class, new FlightDeserializer()).create();
	    return new JsonParser().parse(gson.toJson(this)).getAsJsonObject();
	}
}
