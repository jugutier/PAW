package ar.edu.itba.it.paw.view;

import ar.edu.itba.it.paw.model.Hotel;

public class HotelView {
 private HotelView(){
	 
 }
 public static String getView(Hotel h){
	 int code = h.getCode();
	 String name = h.getName();
	 String description = h.getDescription();
	 
	 return "<h1> "+code+" "+name+" "+description+"<br/></h1>";
 }
}
