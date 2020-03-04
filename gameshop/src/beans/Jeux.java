package beans;

public class Jeux {
	private int id; 
	private String nom;
	private String editeur;
	private String createur;
	private int sortie;
	private float prix;
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	
	public String getCreateur() {
		return createur;
	}
	public void setCreateur(String createur) {
		this.createur = createur;
	}
	
	public int getSortie() {
		return sortie;
	}
	public void setSortie(int sortie) {
		this.sortie = sortie;
	}
	
	public float getPrix() {
		return prix;
	}	
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
		
}
