package bdd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import beans.Commandes;

public class CommandesBdd {
	public Connection connexion = null;
	//Connexion bdd
		public void ConnectDatabase() {
	        try {
	          Class.forName("com.mysql.cj.jdbc.Driver");} 
	        catch (ClassNotFoundException e) {}
	        try {connexion = DriverManager.getConnection(Cste.path, Cste.user, Cste.password);} 
	        catch (SQLException e) {e.printStackTrace();}
			}
		
		//Recuperation d'une commande
		public Commandes RecupCommandes(int id) {
			Commandes commandes = new Commandes();
			Statement statement = null;
			ResultSet resultat = null;
			ConnectDatabase();
			try {
			    statement = connexion.createStatement();
			    resultat = statement.executeQuery("select * from commandes where id = " + id + ";");
			    while (resultat.next()) {
			    	commandes.setId(resultat.getInt("id"));		            
			    	commandes.setUserId(resultat.getInt("userId"));
			    	/*?? Comment faire avec une ArrayList<>
			    	 * commandes.setEditeur(resultat.getArrayList<Commandes>("contenu")); 
			    	 */
			    	commandes.setCreatedAt(resultat.getDate("createdAt"));}
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
			return commandes;}
		
		//Recuperation d'une liste de commandes
		public ArrayList<Commandes> ListeCommandes() {
			ArrayList<Commandes> maListeCommandes = new ArrayList<Commandes>();
			Statement statement = null;
	        ResultSet resultat = null;
	        ConnectDatabase();
	        try {
				     statement = connexion.createStatement();
				     resultat = statement.executeQuery("select * from commandes order by id;");
					Commandes commandes = new Commandes();
				while (resultat.next()) {
					commandes.setId(resultat.getInt("id"));		            
			    	commandes.setUserId(resultat.getInt("userId"));
			    	/*commandes.setEditeur(resultat.getArrayList<Jeux>("contenu")); ??*/
			    	commandes.setCreatedAt(resultat.getDate("createdAt"));}
				maListeCommandes.add(RecupCommandes(commandes.getId()));} 
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
			return maListeCommandes;}

		//POST d'un jeu
		public void AjouterCommandes(int userID, /*ArrayList<Jeux> contenu,*/ Date createdAt) {
		ConnectDatabase();
		        try {
		            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO commandes(userId, createdAt) VALUES (?,?,?);");
		            preparedStatement.setInt(1,userID);
		            //preparedStatement.setArrayList<Commandes>(2, contenu);
		            preparedStatement.setDate(3, createdAt);
		            preparedStatement.executeUpdate();} 
		        catch (SQLException e) {e.printStackTrace();} 
		        finally {
			        try {
			            if (connexion != null)
			                connexion.close();} 
			        catch (SQLException ignore) {}}        
		}
	}

	 