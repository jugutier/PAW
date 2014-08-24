package ar.edu.itba.it.paw.view;

import ar.edu.itba.it.paw.model.Comment;

public class CommentWebView {
	 private CommentWebView(){
		 
	 }
	 public static String getHeaderView(){
		 return "<tr><th>Comment description</th></tr>";
	 }
	 public static String getView(Comment c){		 
		 return "<tr>"+c+"</tr>";
	 }
}
