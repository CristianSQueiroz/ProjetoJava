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

    //Dados de conexão com o banco de dados
    String url = "cristianweb.com.br";
    String porta = "3306";
    String db = "crist609_ProjetoCristiano";
    String driver = "com.mysql.cj.jdbc.Driver";

    String user = "crist609_Marcos";
    String pass = "admin";

    String urlComposto = "jdbc:mysql://" + url + ":" + porta + "/" + db;

    private static MySqlConnect connect;

    //Singleton
    public static MySqlConnect getInstance() {
        //Verifica se existe uma instancia já criada
        if (connect == null) {
            //Caso não exista uma instancia criada cria uma
            connect = new MySqlConnect();
        }
        //Retorno a instancia 
        return connect;
    }

    private MySqlConnect() {

    }

    
    //Abrir a conexão para execução de comando no banco de dados
    public void open() {
        try {
            //Instanciação do driver
            Class.forName(driver).newInstance();
            //obtendo a conexão com o banco de dados
            conn = (Connection) DriverManager.getConnection(urlComposto, user, pass);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            //caso obtenha erro ao tentar acessar ao banco informa ao usuario
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    //Fechar conexão com o banco
    public void close() {
        try {
            //Fecha a conexão com o banco de dados
            conn.close();
        } catch (SQLException e) {
            //caso obtenha erro ao tentar acessar ao banco informa ao usuario
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }

    //Metodo criado para executar os comandos que retornam algum valor do banco de dados
    //com log no console
    public ArrayList<HashMap> executaConsultaPadrao(String cmd) {
        //Criando variavel para armazenar as informaçoes que serão obtidas
        ArrayList<HashMap> retorno = new ArrayList<HashMap>();
        PreparedStatement stmt = null;
        try {
            //Chamando método para abrir a conexão com o banco
            open();
            //preparando a query que será enviada ao banco de dados
            stmt = (PreparedStatement) getConn().prepareStatement(cmd);
            //mostrando no console a query montada
            System.out.println(cmd);
            //executando e guardando as informações que retornaram da consulta
            ResultSet rs = stmt.executeQuery();
            //contando quantas colunas existem nesta consulta
            int colunas = rs.getMetaData().getColumnCount();
            //entrando no loop para varrer os dados obtidos
            while (rs.next()) {
                HashMap row = new HashMap();
                for (int x = 0; x < colunas; x++) {
                    //Armazenando no HashMap no campo da chave o nome da coluna
                    //e no campo valor o que existe naquela linha e coluna 
                    row.put(rs.getMetaData().getColumnName(x + 1), rs.getObject(x + 1));
                }
                //adicionando a linha na lista de retorno
                retorno.add(row);
            }
            //fechando conexão da query
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            //Mesmo que de algum erro garantir que a conexão com o 
            //banco de dados será fechada
            close();
        }
        return retorno;
    }

    //Metodo criado para executar os comandos que retornam algum valor do 
    //banco de dados posibilidade de esconder as query executadas
    public ArrayList<HashMap> executaConsultaPadrao(String cmd, boolean console) {
        //Criando variavel para armazenar as informaçoes que serão obtidas
        ArrayList<HashMap> retorno = new ArrayList<HashMap>();
        PreparedStatement stmt = null;
        try {
            //Chamando método para abrir a conexão com o banco
            open();
            //preparando a query que será enviada ao banco de dados
            stmt = (PreparedStatement) getConn().prepareStatement(cmd);
            //mostrando no console a query montada caso o paramentro seja true
            if (console) {
                System.out.println(cmd);
            }
            //executando e guardando as informações que retornaram da consulta
            ResultSet rs = stmt.executeQuery();
            //contando quantas colunas existem nesta consulta
            int colunas = rs.getMetaData().getColumnCount();
            //entrando no loop para varrer os dados obtidos
            while (rs.next()) {
                HashMap row = new HashMap();
                for (int x = 0; x < colunas; x++) {
                    //Armazenando no HashMap no campo da chave o nome da coluna
                    //e no campo valor o que existe naquela linha e coluna
                    row.put(rs.getMetaData().getColumnName(x + 1), rs.getObject(x + 1));
                }
                //adicionando a linha na lista de retorno
                retorno.add(row);
            }
            stmt.close();
            //fechando conexão da query

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            //Mesmo que de algum erro garantir que a conexão com o 
            //banco de dados será fechada
            close();
        }
        //Retorno padrao do método
        return retorno;
    }

    
    //Método para executar comando no banco de dados que não exigam retorno
    // de informações e que somente precisem de uma confirmação se a query
    //foi executada com sucesso
    public boolean executaComandoPadrao(String cmd) {
        //Criando variavel para executar a query
        PreparedStatement stmt = null;
        try {
            //Chamando método para abrir conexão com o banco de dados
            open();
            //preparando query para execução no banco de dados
            stmt = (PreparedStatement) getConn().prepareStatement(cmd);
            //mostrando no console a query que será executada
            System.out.println(cmd);
            //executando a query no banco
            stmt.execute();
            //fechando a conexão da query com o banco
            stmt.close();
            //retorno true pois não houve qualquer erro
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            //Mesmo que de algum erro garantir que a conexão com o 
            //banco de dados será fechada
            close();
        }
        //retorna falso como padrão do metodo;
        return false;
    }
    
    public static String aplicarApostofo(Object o) {
        return "'" + o.toString() + "'";
    }
    
}
