package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;
    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    // *************************************************************************
    // Méthode qui charge le driver jdbc et qui se connecte à la base de données
    // *************************************************************************
    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/utilisateurs?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
        return instance;
    }
    // *************************************************************************
    // Méthode qui permet de récupérer la connexion
    // *************************************************************************
   public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
   // *************************************************************************
   // Récupération des différents DAO ==> tables de la base de données
   // *************************************************************************
    public JeuxDao getJeuxDao() {
        return new JeuxDaoImpl(this);
    }
    public UtilisateursDao getUtilisateursDao() {
        return new UtilisateursDaoImpl(this);
    }
    public CommandesDao getCommandesDao() {
        return new CommandesDaoImpl(this);
    }
}