package ar.edu.itba.it.paw.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CommentManager {
	private static CommentManager instance;
	private Map<Hotel,List<Comment>> commentsPerHotel;
	private CommentManager(){
		commentsPerHotel =  new HashMap<>();
	}
	public static CommentManager getInstance(){
		if(instance == null){
			instance = new CommentManager();
		}
		return instance;
	}
	public List<Comment> getComments(Hotel h){
		List <Comment> comments = commentsPerHotel.get(h);
		if(comments == null){
			comments = new LinkedList<Comment>();
			commentsPerHotel.put(h, comments);
		}
		return comments;
	}
	public boolean addComent(Comment c,Hotel h){
		return getComments(h).add(c);
		 
	}
}
