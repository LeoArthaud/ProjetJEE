package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import beans.Utilisateurs;

public class UtilisateursDaoImpl implements UtilisateursDao{
private DaoFactory daoFactory;
	
	UtilisateursDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	@Override
	public Utilisateurs RecupUtilisateurs(int id) {
		Utilisateurs utilisateurs = new Utilisateurs();
	     Connection connexion = null;
	     Statement statement = null;
	     ResultSet resultat = null;
	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("select * from utilisateurs where id = " + id + ";");
	            while (resultat.next()) {
	            	 utilisateurs.setId(resultat.getInt("id"));		            
			         utilisateurs.setNom(resultat.getString("nom"));
			         utilisateurs.setPrenom(resultat.getString("prenom"));
			         utilisateurs.setPrenom(resultat.getString("adresse"));}
	            }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return utilisateurs;
	}
	
	@Override
	public ArrayList<Utilisateurs> ListeUtilisateurs(){
		ArrayList<Utilisateurs> maListeUtilisateurs = new ArrayList<Utilisateurs>();
    	Connection connexion = null;
    	Statement statement = null;
    	ResultSet resultat = null;

    try {
        connexion = daoFactory.getConnection();
        statement = connexion.createStatement();
        resultat = statement.executeQuery("select * from utilisateurs order by nom;");

        while (resultat.next()) {
        	Utilisateurs utilisateurs = new Utilisateurs();
        	utilisateurs.setId(resultat.getInt("id"));		            
		    utilisateurs.setNom(resultat.getString("nom"));
		    utilisateurs.setPrenom(resultat.getString("prenom"));
		    utilisateurs.setPrenom(resultat.getString("adresse"));}
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return maListeUtilisateurs;
	}
	
	@Override
	public void AjouterUtilisateurs(String nom , String prenom, String adresse) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO utilisateurs(nom, prenom,adresse) VALUES (?,?,?);");
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, adresse);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
