package Modele;

public class Post {

	private int userId;
	private int id;
	private String title;
	private String body;
	
	
	public Post(int userid, int id, String title, String body) {
		this.userId = userid;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	public Post(int id, String title, String body) {
		this.userId = 0;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	
	public String postPrinte() {
		String s = "";
		s = "userId : " + String.valueOf(userId) +" " + "Id :" + " " + String.valueOf(id) +" " + "Prénom :" + " " + title + " "+ "Nom :"+ " " + body +"\n";
		return s;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
	
	
}
