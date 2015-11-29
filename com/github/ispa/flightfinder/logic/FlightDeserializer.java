package com.github.ispa.flightfinder.logic;

import java.lang.reflect.Type;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class FlightDeserializer implements JsonDeserializer<Flight>{

	@Override
	public Flight deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Airports airports = Airports.getInstance();
		if (json.getAsJsonObject().get("origin").isJsonPrimitive()) {
			return new Flight(
					json.getAsJsonObject().get("id").getAsInt(), 
					airports.getAirport(json.getAsJsonObject().get("origin").getAsInt()),
					airports.getAirport(json.getAsJsonObject().get("destination").getAsInt()),
					json.getAsJsonObject().get("departure_timestamp").getAsInt()
					);
		} else {
			return new Flight(
					json.getAsJsonObject().get("id").getAsInt(), 
					airports.getAirport(json.getAsJsonObject().get("origin").getAsJsonObject().get("id").getAsInt()),
					airports.getAirport(json.getAsJsonObject().get("destination").getAsJsonObject().get("id").getAsInt()),
					json.getAsJsonObject().get("departure_timestamp").getAsInt()
					);
		}
		
	}


}
