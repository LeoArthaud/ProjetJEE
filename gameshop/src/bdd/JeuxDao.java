package bdd;

import java.util.ArrayList;
import java.util.Date;

import beans.Jeux;

public interface JeuxDao {
	void AjouterJeux(String nom , String editeur, String createur, Date sortie, Float prix);
	ArrayList<Jeux> ListeJeux();
	Jeux RecupJeux(int id);
}
