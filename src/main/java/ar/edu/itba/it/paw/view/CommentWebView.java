package ar.edu.itba.it.paw.view;

import ar.edu.itba.it.paw.model.Comment;
import ar.edu.itba.it.paw.model.UserInfo;

public class CommentWebView {
	 private CommentWebView(){
		 
	 }
	 private static String getHeaderView(UserInfo userInfo){
		 return "<span><strong>name: </strong>"+userInfo.getName()+"</span><br/><span><strong>email: </strong>"+userInfo.getEmail()+"</span><br/>";
	 }
	 public static String getView(Comment c){
		 UserInfo userInfo = c.getUserInfo();		
		 return  "<tr><div>"+getHeaderView(userInfo)+"<p><strong>comment: </strong>"+c.getText()+"</p></div></tr>";
	 }
}
