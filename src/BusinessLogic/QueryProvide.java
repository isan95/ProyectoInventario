/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Conexion;
import Data.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author POLANCO
 */
public class QueryProvide {

    private Connection connProvide;
    private ResultSet rs;
    private int cantProvide;

    public int getCantProvide() {
        return this.cantProvide;
    }

    public void closeConnectionProvide() {
        try {
            this.connProvide.close();
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public boolean insertProvide(Provider pro) {
        PreparedStatement pqp = null;
        this.connProvide = Conexion.getConecction();
        String sql = "INSERT INTO provider (NIT_CC,business_name, phone, adress, e_mail, type) VALUES (?,?,?,?,?,?)";
        try {
            pqp = connProvide.prepareStatement(sql);
            pqp.setString(1, pro.getNIT());
            pqp.setString(2, pro.getNameProvide());
            pqp.setString(3, pro.getPhoneProvide());
            pqp.setString(4, pro.getAdressProvide());
            pqp.setString(5, pro.getEmailProvide());
            pqp.setInt(6, pro.getType());
            pqp.execute();
            return true;

        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                connProvide.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }

    public ResultSet getProvide() {
        PreparedStatement pqp = null;
        this.connProvide = Conexion.getConecction();
        String sql = "SELECT * FROM provider";
        try {
            pqp = connProvide.prepareStatement(sql);
            rs = pqp.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantProvide = rsMd.getColumnCount();

        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getProvideForWhere(String attribute, String value) {
        PreparedStatement pqw = null;
        String sql = null;
        this.connProvide = Conexion.getConecction();
        switch (attribute) {
            case "NIT o C.C":
                sql = "SELECT NIT_CC,business_name, phone, adress, e_mail, type FROM provider WHERE NIT_CC LIKE" + "'" + value + "%'";
                break;
            case "Razon social":
                sql = "SELECT NIT_CC,business_name, phone, adress, e_mail, type FROM provider WHERE business_name LIKE" + " '%" + value + "%'";
                break;
            case "Tipo":
                sql = "SELECT NIT_CC,business_name, phone, adress, e_mail, type FROM provider WHERE type = " + Integer.parseInt(value);
                break;
        }

        try {
            pqw = this.connProvide.prepareStatement(sql);
            rs = pqw.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantProvide = rsMd.getColumnCount();
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public boolean deleteProvide(String NIT) {
        PreparedStatement pqu = null;
        boolean delete = false;
        String sql = "DELETE  FROM provider WHERE NIT_CC = '" + NIT + "'";
        try {
            this.connProvide = Conexion.getConecction();
            pqu = this.connProvide.prepareStatement(sql);
            pqu.execute();
            delete = true;
        } catch (SQLException e) {
            System.err.print(e);
        }

        return delete;
    }
    
     public boolean updateProvide(Provider pro, String NIT) {
        PreparedStatement pqu = null;
        boolean updated = false;

        String sql = "UPDATE provider SET business_name = ?, phone = ?, e_mail = ?, adress = ?, type = ? WHERE NIT_CC = '" + NIT + "'";
        try {
            this.connProvide = Conexion.getConecction();
            pqu = this.connProvide.prepareStatement(sql);
            pqu.setString(1, pro.getNameProvide());
            pqu.setString(2, pro.getPhoneProvide());
            pqu.setString(3, pro.getEmailProvide());
            pqu.setString(4, pro.getAdressProvide());
            pqu.setInt(5, pro.getType());
            pqu.execute();
            updated = true;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return updated;
    }
     public void closeConnection(){
         try{
             connProvide.close();
         }
         catch(SQLException e){
             System.out.println(e);
         }
     }
}
