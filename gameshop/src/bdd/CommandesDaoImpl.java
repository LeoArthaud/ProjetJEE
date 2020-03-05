package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import beans.Commandes;

public class CommandesDaoImpl implements CommandesDao{
private DaoFactory daoFactory;
	
	CommandesDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	@Override
	public Commandes RecupCommandes(int id) {
		Commandes commandes = new Commandes();
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	        try {
	            connexion = daoFactory.getConnection();
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
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return commandes;
	}
	
	@Override
	public ArrayList<Commandes> ListeCommandes(){
		ArrayList<Commandes> maListeCommandes = new ArrayList<Commandes>();
    	Connection connexion = null;
    	Statement statement = null;
    	ResultSet resultat = null;
    try {
        connexion = daoFactory.getConnection();
        statement = connexion.createStatement();
        resultat = statement.executeQuery("select * from commandes order by id;");

        while (resultat.next()) {
        	Commandes commandes = new Commandes();
        	commandes.setId(resultat.getInt("id"));		            
	    	commandes.setUserId(resultat.getInt("userId"));
	    	/*commandes.setEditeur(resultat.getArrayList<Jeux>("contenu")); ??*/
	    	commandes.setCreatedAt(resultat.getDate("createdAt"));}
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return maListeCommandes;
	}
	
	@Override
	public void AjouterCommandes(int userID, /*ArrayList<Jeux> contenu,*/ Date createdAt){
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO commandes(userId, createdAt) VALUES (?,?,?);");
            preparedStatement.setInt(1,userID);
            //preparedStatement.setArrayList<Commandes>(2, contenu);
            preparedStatement.setDate(3, createdAt);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
}
