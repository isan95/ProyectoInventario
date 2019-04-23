/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Client;
import Data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author POLANCO
 */
public class QueryClient {
    Connection conClient;
    ResultSet rs;
    int cantClient;
    
    public int getCantClient() {
        return cantClient;
    }
    
    public void closeConnection() {
        try {
            this.conClient.close();
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
    public boolean insertClient(Client client) {
        PreparedStatement pqp = null;
        this.conClient = Conexion.getConecction();
        String sql = "INSERT INTO client (document,name_client,first_lastname_client,last_lastname_cliente,phone_client,email_client) VALUES (?,?,?,?,?,?)";
        try {
            pqp = conClient.prepareStatement(sql);
            pqp.setString(1, client.getDocument());
            pqp.setString(2, client.getName());
            pqp.setString(3, client.getFirstLastName());
            pqp.setString(4, client.getLastLastName());
            pqp.setString(5, client.getPhone());
            pqp.setString(6, client.getEmail());
            pqp.execute();
            return true;

        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                conClient.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }
    
    public ResultSet getClientForWhere(String attribute, String value) {
        PreparedStatement pqw = null;
        String sql = null;
        this.conClient = Conexion.getConecction();
        if (attribute.equals("Documento")) {
            sql = "SELECT * FROM client WHERE  document LIKE" + "'" + value + "%'";
        } else {
            if (attribute.equals("Nombre y apellido")) {
                sql = "SELECT * FROM client WHERE  name_client LIKE " + "'" + value + "%' OR  first_lastName_client LIKE '"+value+"%' OR last_lastName_cliente  LIKE '"+value+"%'";
            }
        }
        try {
            pqw = this.conClient.prepareStatement(sql);
            rs = pqw.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantClient = rsMd.getColumnCount();
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }
}
