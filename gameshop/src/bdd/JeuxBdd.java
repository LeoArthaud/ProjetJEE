package bdd;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import beans.Jeux;

public class JeuxBdd {
	public Connection connexion = null;
	
	//Connexion bdd
	public void ConnectDatabase() {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");} 
        catch (ClassNotFoundException e) {}
        try {connexion = DriverManager.getConnection(Cste.path, Cste.user, Cste.password);} 
        catch (SQLException e) {e.printStackTrace();}
		}
	
	//Recuperation d'un jeu
	public Jeux RecupJeux(int id) {
		Jeux jeux = new Jeux();
		Statement statement = null;
		ResultSet resultat = null;
		ConnectDatabase();
		try {
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery("select * from jeux where id = " + id + ";");
		    while (resultat.next()) {
		          jeux.setId(resultat.getInt("id"));		            
		          jeux.setNom(resultat.getString("nom"));
		          jeux.setEditeur(resultat.getString("editeur"));
		          jeux.setCreateur(resultat.getString("createur"));
		          jeux.setSortie(resultat.getDate("sortie"));
		          jeux.setPrix(resultat.getFloat("prix"));}
		        } 
		catch (SQLException e) {} 
		finally {
			try {
		        if (resultat != null)
		        resultat.close();
		        if (statement != null)
		        	statement.close();
		        if (connexion != null)
		        	connexion.close();} 
			catch (SQLException ignore) {}
		        }        
		return jeux;}
	
	//Recuperation d'une liste de jeux
	public ArrayList<Jeux> ListeJeux() {
		ArrayList<Jeux> maListeJeux = new ArrayList<Jeux>();
		Statement statement = null;
        ResultSet resultat = null;
        ConnectDatabase();
        try {
			     statement = connexion.createStatement();
			     resultat = statement.executeQuery("select * from jeux order by nom;");
			     Jeux jeux = new Jeux();
			while (resultat.next()) {
				  jeux.setId(resultat.getInt("id"));		            
		          jeux.setNom(resultat.getString("nom"));
		          jeux.setEditeur(resultat.getString("editeur"));
		          jeux.setCreateur(resultat.getString("createur"));
		          jeux.setSortie(resultat.getDate("sortie"));
		          jeux.setPrix(resultat.getFloat("prix"));}
			maListeJeux.add(RecupJeux(jeux.getId()));} 
        catch (SQLException e) {} 
        finally {
		       try {
		       if (resultat != null)
		    	   resultat.close();
		       if (statement != null)
		           statement.close();
		       if (connexion != null)
		    	   connexion.close();} 
		       catch (SQLException ignore) {}}        
		return maListeJeux;}

	//POST d'un jeu
	public void AjouterJeux(String nom , String editeur, String createur, Date sortie, Float prix) {
	ConnectDatabase();
	        try {
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO jeux(nom, editeur, createur, sortie, prix) VALUES (?,?,?,?,?);");
	            preparedStatement.setString(1,nom);
	            preparedStatement.setString(2, editeur);
	            preparedStatement.setString(3, createur);
	            preparedStatement.setDate(4,(java.sql.Date) sortie);
	            preparedStatement.setFloat(3, prix);
	            preparedStatement.executeUpdate();} 
	        catch (SQLException e) {e.printStackTrace();} 
	        finally {
		        try {
		            if (connexion != null)
		                connexion.close();} 
		        catch (SQLException ignore) {}}        
	}
}

 