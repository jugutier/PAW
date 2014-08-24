package ar.edu.itba.it.paw.model;

public class Comment {
	private final String text;
	private final UserInfo userInfo;
	public Comment(UserInfo userInfo,String comment){
		this.userInfo = userInfo;
		this.text = comment;
	}
	public String getText() {
		return text;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
}
