package bdd;

import java.util.ArrayList;
import java.sql.Date;

import beans.Commandes;

public interface CommandesDao {
	ArrayList<Commandes> ListeCommandes();
	Commandes RecupCommandes(int id);
	void AjouterCommandes(int userID,/*ArrayList<Jeux> contenu,*/ Date createdAt);
}
