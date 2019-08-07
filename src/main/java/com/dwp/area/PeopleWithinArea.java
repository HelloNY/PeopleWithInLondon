package com.dwp.area;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PeopleWithinArea {

	static double LondonLatitude = 51.509865;
	static double Londonlongitude = -0.118092;
	
	
	public Person getPersonById(String url, int userId) {

		String completeUrl = url + "user/" + userId;

		Person person = null;
		try {
			InputStreamReader reader = new InputStreamReader(new URL(completeUrl).openStream());
			person = new Gson().fromJson(reader, Person.class);

		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return person;

	}
	
	
	public List<Person> getPeople50MilesOfLondon( List<Person> people) {
		
		List<Person> people50MilesOfLondon = people.stream()
		 .filter( p -> getdDistance(LondonLatitude, Londonlongitude, p.getLatitude(),
					p.getLongitude())<=600.00).collect(Collectors.toList());
	
		return people50MilesOfLondon;

	}



	public List<Person> getPeopleFromCity(String url, String city) {
		
		String completeUrl = url+"city/"+city+"/users";
		List<Person> p =  getPeople(completeUrl);
		return getPeople50MilesOfLondon(p);
	}

	public List<Person> getAllPeople(String url) {

		String completeUrl = url+"users";
		List<Person> p =  getPeople(completeUrl);
		return getPeople50MilesOfLondon(p);
	
	}

	public List<Person> getPeople(String url) {

		List<Person> people = new ArrayList<Person>();
		try {
			InputStreamReader reader = new InputStreamReader(new URL(url).openStream());
			people = new Gson().fromJson(reader, new TypeToken<List<Person>>() {
			}.getType());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return people;
	}

	private static double getdDistance(double startLatitude, double startLongitude, double endLatitude,
			double endLongitude) {
		if ((startLatitude == endLatitude) && (startLongitude == endLongitude)) {
			return 0;
		} else {
			double theta = startLongitude - endLongitude;
			double distance = Math.sin(Math.toRadians(startLatitude)) * Math.sin(Math.toRadians(endLatitude))
					+ Math.cos(Math.toRadians(startLatitude)) * Math.cos(Math.toRadians(endLatitude))
							* Math.cos(Math.toRadians(theta));
			distance = Math.acos(distance);
			distance = Math.toDegrees(distance);
			distance = distance * 60 * 1.1515;

			return (distance);
		}
	}

}
