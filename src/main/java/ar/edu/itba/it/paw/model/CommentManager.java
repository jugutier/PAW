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
		comments.add(new Comment(new UserInfo("John Doe", "john@user.com"),"This is a test comment from John"));//TODO:remove and generate stub
		comments.add(new Comment(new UserInfo("Jane Doe", "jane@user.com"),"This is a test comment from Jane"));//TODO:remove and generate stub
		return comments;
	}
}
