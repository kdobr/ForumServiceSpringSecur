package telran.ashkelon2018.forum.api;

public interface ForumAndPoint {
	String ACCOUNT = "/account";// PUT-owner GET-authenticated
	String ACCOUNT_ID = "/account/{id}"; // delete - owner, admin, moderator
	String ACCOUNT_ROLE = "/account/role/{id}/{role}";// delete put - admin
	String ACCOUNT_PASSWORD = "/account/password"; //put  owner
	String FORUM_POST = "/forum/post"; //post - auth, put - owner 
	String FORUM_POST_ID = "/forum/post/{id}"; // get - auth, del-owner
	String FORUM_POST_LIKE = "/forum/post/{id}/like"; // put - auth
	String FORUM_POST_COMMENT = "/forum/post/{id}/comment"; // put - auth
	String FORUM_POSTS = "/forum/posts"; 
	
	

}
