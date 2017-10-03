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

    /**
     *
     * @param psIP
     * @param psPort
     * @param psUT
     * @param psMDP
     * @param psBD
     * @return
     */
    public static Connection seConnecter(String psIP, String psPort, String psUT, String psMDP, String psBD) {
        Connection lcn = null;

        String lsDSN = "jdbc:mysql://" + psIP + ":" + psPort + "/" + psBD;

        try {
            lcn = DriverManager.getConnection(lsDSN, psUT, psMDP);
        } catch (SQLException e) {

        }
        return lcn;
    } /// seConnecter

    /**
     *
     * @param lcn
     */
    public static void seDeconnecter(Connection lcn) {
        lcn = null;
    } /// seDeconnecter

    /**
     *
     * @param pcnx
     * @param psSQL
     * @return
     */
    public static String getData(Connection pcnx, String psSQL) {
        StringBuilder lsbContenu = new StringBuilder();
        try {
            Statement lstSQL = pcnx.createStatement();
            ResultSet lrs = lstSQL.executeQuery(psSQL);
            while (lrs.next()) {
                lsbContenu.append("[");
                lsbContenu.append(lrs.getString(1));
                lsbContenu.append("] ");
                lsbContenu.append(lrs.getString(2));
                lsbContenu.append(System.getProperty("line.separator"));
            }
        } catch (SQLException e) {
            lsbContenu.append(e.getMessage());
        }
        return lsbContenu.toString();
    } /// getData

    public static void main(String[] args) {
        // --- Déclarations
        Connection lcn;
        String lsServeur;
        String lsPort;
        String lsBD;
        String lsUt;
        String lsMdp;
        String lsSelect;

        // --- Pour une connexion MySQL native
        lsServeur = "127.0.0.1";
        lsPort = "3306";
        lsBD = "cours";
        lsUt = "root";
        lsMdp = "";
        lsSelect = "SELECT * FROM villes";

        lcn = seConnecter(lsServeur, lsPort, lsUt, lsMdp, lsBD);
        String lsContenu = getData(lcn, lsSelect);
        seDeconnecter(lcn);

        System.out.println(lsContenu);
    } /// main
}
