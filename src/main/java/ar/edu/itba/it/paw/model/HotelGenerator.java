package ar.edu.itba.it.paw.model;

import java.util.LinkedList;
import java.util.List;

public class HotelGenerator {
	private HotelGenerator(){
		
	}
	
	public static List<Hotel> generate(){
		List<Hotel> hotels = new LinkedList<Hotel>();
		for(int i =0;i<50;i++){
			hotels.add(new Hotel(getRandomCode(),"Name "+i,"Desc"+i));
		}
		return hotels;
	}
	private static int getRandomCode(){
		return (int) Math.floor(Math.random()*1000);
	}
}
