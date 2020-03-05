package bdd;

import java.util.ArrayList;

import beans.Utilisateurs;

public interface UtilisateursDao {
	void AjouterUtilisateurs(String nom , String prenom, String adresse);
	ArrayList<Utilisateurs> ListeUtilisateurs();
	Utilisateurs RecupUtilisateurs(int id);

}
