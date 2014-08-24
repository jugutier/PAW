package ar.edu.itba.it.paw.model;

import java.util.List;

public class HotelManager {
	private	static HotelManager instance;
	List<Hotel> hotels;
	private HotelManager(){}
	public static HotelManager getInstance(){
		if(instance == null){
			instance = new HotelManager();
		}
		return instance;
	}
	public List<Hotel> getHotels(){
		if(hotels == null){
			hotels = HotelGenerator.generate();
		}
		return hotels;
	}
}
