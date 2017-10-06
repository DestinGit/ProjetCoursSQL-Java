/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetcourssql.java;
import java.sql.*;
/**
 *
 * @author formation
 */
public class RequetePrepareeSelect {

    public static void main(String[] args) {

        try {
            // --- Connexion
            String lsDSN = "jdbc:mysql://127.0.0.1:3306/cours";
            Connection lcn = DriverManager.getConnection(lsDSN, "root", "");

            // --- SELECT
            String lsSQL = "SELECT * FROM villes WHERE cp = ?";

            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = lcn.prepareStatement(lsSQL);

            // --- Valorisation du ou des parametre(s)
            // --- Les valeurs pourraient etre saisies au clavier
            lpst.setString(1, "75011");

            // --- Execution de la requete
            ResultSet lrs = lpst.executeQuery();
            if(lrs.next()) {
                System.out.println(lrs.getString("cp") + "-" + lrs.getString("nom_ville"));
            }
            else {
                System.out.println("Aucun résultat!!!");
            }

            lrs.close();
            lpst.close();
            lcn.close();

        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

  } /// main
    
}
