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
public class VillesSelect {
    public static void main(String[] args) {
        // --- Déclarations
        Connection lcn;
        Statement lstSQL;
        ResultSet lrs;
        String lsPilote;
        String lsServeur;
        String lsPort;
        String lsBD;
        String lsUt;
        String lsMdp;
        String lsDSN;
        String lsSelect;
        StringBuilder lsbContenu = new StringBuilder("");

        // --- Pour une connexion MySQL native
        lsServeur = "127.0.0.1";
        lsPort = "3306";
        lsBD = "cours";
        lsUt = "root";
        lsMdp = "";
        lsPilote = "org.gjt.mm.mysql.Driver";
        lsDSN = "jdbc:mysql://" + lsServeur + ":" + lsPort + "/" + lsBD;
        lsbContenu = new StringBuilder("");
        try {
            Class.forName(lsPilote);
            lcn = DriverManager.getConnection(lsDSN, lsUt, lsMdp);
            lsSelect = "SELECT * FROM villes";
            lstSQL = lcn.createStatement();
            lrs = lstSQL.executeQuery(lsSelect);
            while (lrs.next()) {
                lsbContenu.append("[");
                lsbContenu.append(lrs.getString(1));
                lsbContenu.append("] ");
                lsbContenu.append(lrs.getString(2));
                lsbContenu.append(System.getProperty("line.separator"));
            }
            lrs.close();
            lstSQL.close();
            lcn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(lsbContenu.toString());
    } /// main
    
}
