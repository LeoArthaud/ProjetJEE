package beans;

public class Utilisateurs {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private boolean isAdmin;
	
	public int getId() {
		return id;
	}
	//public void setId(int id) {
	//	this.id = id;
	//}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
