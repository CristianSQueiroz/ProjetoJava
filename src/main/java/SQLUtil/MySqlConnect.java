/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLUtil;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class MySqlConnect {

    Connection conn;

    String url = "216.172.161.42";
    String porta = "3306";
    String db = "crist609_ProjetoCristiano";
    String driver = "com.mysql.cj.jdbc.Driver";

    String user = "crist609_Marcos";
    String pass = "admin";

    String urlComposto = "jdbc:mysql://" + url + ":" + porta + "/" + db;

    private static MySqlConnect connect;

    public static MySqlConnect getInstance() {
        if (connect == null) {
            connect = new MySqlConnect();
        }
        return connect;
    }

    private MySqlConnect() {

    }

    public void open() {
        try {
            System.out.println("Abrindo conexão");
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(urlComposto, user, pass);

        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            if (e.getMessage().contains("")) {

            }
        }
        //statusbar.setProcesso("");
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println((e.getMessage()));
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public ArrayList<HashMap> executaConsultaPadrao(String cmd) {
        ArrayList<HashMap> retorno = new ArrayList<HashMap>();
        PreparedStatement stmt = null;
        try {
            open();
            stmt = (PreparedStatement) getConn().prepareStatement(cmd);
            System.out.println(cmd);
            ResultSet rs = stmt.executeQuery();
            int colunas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                HashMap row = new HashMap();
                for (int x = 0; x < colunas; x++) {
                    row.put(rs.getMetaData().getColumnName(x + 1), rs.getObject(x + 1));
                }
                retorno.add(row);
            }
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            close();
        }
        return retorno;
    }

    public ArrayList<HashMap> executaConsultaPadrao(String cmd, boolean console) {
        ArrayList<HashMap> retorno = new ArrayList<HashMap>();
        PreparedStatement stmt = null;
        try {
            open();
            stmt = (PreparedStatement) getConn().prepareStatement(cmd);
            if (console) {
                System.out.println(cmd);
            }
            ResultSet rs = stmt.executeQuery();
            int colunas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                HashMap row = new HashMap();
                for (int x = 0; x < colunas; x++) {
                    row.put(rs.getMetaData().getColumnName(x + 1), rs.getObject(x + 1));
                }
                retorno.add(row);
            }
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            close();
        }
        return retorno;
    }

    public boolean executaComandoPadrao(String cmd) {
        ArrayList<HashMap> retorno = new ArrayList<HashMap>();
        HashMap row = new HashMap();
        PreparedStatement stmt = null;
        try {
            open();
            stmt = (PreparedStatement) getConn().prepareStatement(cmd);
            System.out.println(cmd);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            close();
        }
        return false;
    }
    
    public static String aplicarApostofo(Object o) {
        return "'" + o.toString() + "'";
    }
    
}
