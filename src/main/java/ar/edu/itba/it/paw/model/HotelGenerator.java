package ar.edu.itba.it.paw.model;

import java.util.LinkedList;
import java.util.List;

public class HotelGenerator {
	private HotelGenerator(){
		
	}
	
	public static List<Hotel> generate(){
		List<Hotel> hotels = new LinkedList<Hotel>();
		hotels.add(new Hotel(3,"medrano plaza","hotel de lalo"));
		return hotels;
	}
}
