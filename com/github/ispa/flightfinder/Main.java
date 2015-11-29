package com.github.ispa.flightfinder;

import com.github.ispa.flightfinder.logic.Airports;
import com.github.ispa.flightfinder.logic.Flights;
import com.github.ispa.flightfinder.utils.FlightfinderApi;

public class Main {

	public static void main(String[] args) {
		FlightfinderApi.getInstance();
		Airports.getInstance();
		Flights.getInstance();
		
	    System.out.println("Origin of flight 0: " + Flights.getInstance().getFlight(0).getOrigin().getDisplayname());
		//tests();
	}
	
	public static void tests() {
		
		/*
		Gson prettyJsonPrinter = new GsonBuilder().setPrettyPrinting().create();
		Gson gson = new Gson();
		JsonObject response, data;
		FlightfinderApi api = FlightfinderApi.getInstance();
		*/
		
		/*
		System.out.println("\n" + randomUtils.buildStringFromChar('-', 30));
		System.out.println("Get origin of flight with id 2: ");
		response = api
				.fromSubjectType("flight")
				.getSubject(2)
				.selectProperty("origin")
				.get();
		System.out.println(prettyJsonPrinter.toJson(response));
		*/
		
		
		/*
		System.out.println("\n" + randomUtils.buildStringFromChar('-', 30));
		System.out.println("Ask 'tests' with some get data: {var1=val1}");
		data = new JsonObject();
		data.addProperty("var1", "val1");
		response = api
				.fromSubjectType("tests")
				.get(data);
		System.out.println(prettyJsonPrinter.toJson(response));
		*/
		
		
		/*
		System.out.println("\n" + randomUtils.buildStringFromChar('-', 30));
		System.out.println("Ask 'tests' with some get data");
		data = new JsonParser().parse("{\"var1\":\"val1\", \"var2\":{\"var2.1\":\"val2.1\",\"var2.2\":\"val2.2&a\"}}").getAsJsonObject();
		data.addProperty("var3", "val3");
		response = api
				.fromSubjectType("tests")
				.get(data);
		System.out.println(prettyJsonPrinter.toJson(response));
		*/
		
		
		/*
		GsonBuilder gsonb = new GsonBuilder();
		gsonb.registerTypeAdapter(Flight.class, new FlightDeserializer());
		gsonb.registerTypeAdapter(Flight.class, new FlightInstanceCreator());
		gson = gsonb.create();
		
		System.out.println("\n" + randomUtils.buildStringFromChar('-', 30));
		System.out.println("Get flight 2. Put it in a Flight object. Display Flight object as json: ");
		response = api
				.fromSubjectType("flight")
				.getSubject(2)
				.get();
		if (response.get("status").toString().equals("ok")) {
			Flight f = gson.fromJson(response.get("request").toString(), Flight.class);
			JsonObject jo = new JsonParser().parse(gson.toJson(f)).getAsJsonObject();
			System.out.println(prettyJsonPrinter.toJson(jo));
		} else {
			System.out.println(response.toString());
		}
		*/
		
		/*
		System.out.println("\n" + randomUtils.buildStringFromChar('-', 30));
		System.out.println("Loads airports");
		Airports airports = Airports.getInstance();
		for (int i = 0; i < 10; i++) {
			response = api
					.fromSubjectType("airport")
					.getSubject(i)
					.get();
			if (response.get("status").getAsString().equals("ok")) {
				Airport f = gson.fromJson(response.get("request").toString(), Airport.class);
				airports.addAirport(f);
			} else {
				System.out.println(response.toString());
				System.exit(1);
			}
		}
		System.out.println(prettyJsonPrinter.toJson(airports));
		*/
		
		/*
		System.out.println("\n" + randomUtils.buildStringFromChar('-', 30));
		System.out.println("Loads airports");
		Airports airports = Airports.getInstance();
		for (int i = 0; i < 10; i++) {
			response = api
					.fromSubjectType("airport")
					.getSubject(i)
					.get();
			if (response.get("status").getAsString().equals("ok")) {
				Airport f = gson.fromJson(response.get("request").toString(), Airport.class);
				airports.addAirport(f);
			} else {
				System.out.println(response.toString());
				System.exit(1);
			}
		}
		System.out.println("Loaded");
		System.out.println(prettyJsonPrinter.toJson(airports));
		*/
		
		
		/*
		System.out.println("\n" + randomUtils.buildStringFromChar('-', 30));
		System.out.println("Loads airports");
		Airports airports = Airports.getInstance();
		response = api.fromSubjectType("airports").get();
		if (response.get("status").getAsString().equals("ok") && response.get("request").isJsonArray()) {
			for(JsonElement airport : response.get("request").getAsJsonArray()) {
				airports.addAirport(gson.fromJson(airport, Airport.class));
			}
		} else {
			System.out.println(response.toString());
			System.exit(1);
		}
		System.out.println("Loaded");
		System.out.println(prettyJsonPrinter.toJson(airports));
		*/
		
		
		
		/*
		Flight action = new Flight(1, 2, 3, 4);

	    String json = new Gson().toJson(action);
	    System.out.println(json);

	    GsonBuilder gsonBuilder = new GsonBuilder();
	    //gsonBuilder.registerTypeAdapter(Flight.class, new FlightInstanceCreator());
	    gsonBuilder.registerTypeAdapter(Flight.class, new FlightDeserializer());
	    Gson gson = gsonBuilder.create();
	    Flight actionCopy = gson.fromJson(json, Flight.class);
	    System.out.println(gson.toJson(actionCopy));
		*/
	}
}
