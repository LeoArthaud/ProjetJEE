package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import beans.Jeux;

public class JeuxDaoImpl implements JeuxDao{
	private DaoFactory daoFactory;
	
	JeuxDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	@Override
	public Jeux RecupJeux(int id) {
		Jeux jeux = new Jeux();
	     Connection connexion = null;
	     Statement statement = null;
	     ResultSet resultat = null;
	        try {
	            connexion = daoFactory.getConnection();
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
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return jeux;
	}
	
	@Override
	public ArrayList<Jeux> ListeJeux(){
		ArrayList<Jeux> maListeJeux = new ArrayList<Jeux>();
    	Connection connexion = null;
    	Statement statement = null;
    	ResultSet resultat = null;

    try {
        connexion = daoFactory.getConnection();
        statement = connexion.createStatement();
        resultat = statement.executeQuery("select * from jeux order by nom;");

        while (resultat.next()) {
        	Jeux jeux = new Jeux();
        	jeux.setId(resultat.getInt("id"));		            
	        jeux.setNom(resultat.getString("nom"));  
	        jeux.setEditeur(resultat.getString("editeur"));
	        jeux.setCreateur(resultat.getString("createur"));
	        jeux.setSortie(resultat.getDate("sortie"));
	        jeux.setPrix(resultat.getFloat("prix"));}
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return maListeJeux;
	}
	
	@Override
	public void AjouterJeux(String nom , String editeur, String createur, Date sortie, Float prix) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO jeux(nom, editeur, createur, sortie, prix) VALUES (?,?,?,?,?);");
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2, editeur);
            preparedStatement.setString(3, createur);
            preparedStatement.setDate(4,(java.sql.Date) sortie);
            preparedStatement.setFloat(3, prix);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
}
