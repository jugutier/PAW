package ar.edu.itba.it.paw.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class HotelGenerator {
	private HotelGenerator(){
		
	}
	
	public static List<Hotel> generate(){
		//getHotels();
		List<Hotel> hotels = new LinkedList<Hotel>();
		for(int i =0;i<15;i++){
			hotels.add(new Hotel(getRandomCode(),"Name "+i,"Desc"+i));
		}
		return hotels;
	}
	private static int getRandomCode(){
		return (int) Math.floor(Math.random()*1000);
	}
	private static void getHotels(){
		Connection c= getConnection();
		Statement s = null;
		if(c!=null){
			try {
				s = c.createStatement();
				ResultSet rs = s.executeQuery("SELECT * FROM PEPE");
				while(rs.next()){
					System.out.println(rs.getString("NAME"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
		        if (s != null) { try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} }
		    }
		}
	}
	private static Connection getConnection(){
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/hotelapp", "paw",
					"123456");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 
		}
 
		return connection;
	}
	
}
