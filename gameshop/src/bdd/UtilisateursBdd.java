package bdd;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateurs;

public class UtilisateursBdd {
	public Connection connexion = null;
	//Connexion bdd
	public void ConnectDatabase() {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");} 
        catch (ClassNotFoundException e) {}
        try {connexion = DriverManager.getConnection(Cste.path, Cste.user, Cste.password);} 
        catch (SQLException e) {e.printStackTrace();}
		}
	
	//Recuperation d'un utilisateur
	public Utilisateurs RecupUtilisateurs(int id) {
		Utilisateurs utilisateurs = new Utilisateurs();
		Statement statement = null;
		ResultSet resultat = null;
		ConnectDatabase();
		try {
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery("select * from utilisateurs where id = " + id + ";");
		    while (resultat.next()) {
		          utilisateurs.setId(resultat.getInt("id"));		            
		          utilisateurs.setNom(resultat.getString("nom"));
		          utilisateurs.setPrenom(resultat.getString("prenom"));
		          utilisateurs.setPrenom(resultat.getString("adresse"));}
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
		return utilisateurs;}
	
	//Recuperation d'une liste d'utilisateur
	public ArrayList<Utilisateurs> ListeUtilisateurs() {
		ArrayList<Utilisateurs> maListeUtilisateurs = new ArrayList<Utilisateurs>();
		Statement statement = null;
        ResultSet resultat = null;
        ConnectDatabase();
        try {
			     statement = connexion.createStatement();
			     resultat = statement.executeQuery("select * from utilisateurs order by nom;");
			     Utilisateurs utilisateurs = new Utilisateurs();
			while (resultat.next()) {
			      utilisateurs.setId(resultat.getInt("id"));		            
			      utilisateurs.setNom(resultat.getString("nom"));
			      utilisateurs.setPrenom(resultat.getString("prenom"));
			      utilisateurs.setPrenom(resultat.getString("adresse"));
			      }
			maListeUtilisateurs.add(RecupUtilisateurs(utilisateurs.getId()));} 
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
		return maListeUtilisateurs;}

	//POST un utilisateur
	public void AjouterUtilisateurs(String nom , String prenom, String adresse) {
	ConnectDatabase();
	        try {
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateurs(nom, prenom,adresse) VALUES (?,?,?);");
	            preparedStatement.setString(1,nom);
	            preparedStatement.setString(2, prenom);
	            preparedStatement.setString(3, adresse);
	            preparedStatement.executeUpdate();} 
	        catch (SQLException e) {e.printStackTrace();} 
	        finally {
		        try {
		            if (connexion != null)
		                connexion.close();} 
		        catch (SQLException ignore) {}}        
	}
}

