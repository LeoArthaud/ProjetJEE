package beans;

import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Commandes {
	private int id;
	private int userId; //foreign key
	private ArrayList<Jeux> contenu;
	private Date createdAt; 
	
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public ArrayList<Jeux> getListeJeux(){
		return contenu;
	}
	 public Date getCreatedAt() {
	//String stringB;
	//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//Date date = new Date();
	//stringB = dateFormat.format(date) ;
	//createdAt = SimpleDateFormat.parse(stringB)
	return createdAt;
	 }
}
