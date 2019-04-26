/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Bill;
import Data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author POLANCO
 */
public class QueryBill {
     private Connection connBill;
     private ResultSet rs;
     public int  getLastIdBill(){
        int rsi = 0;
        connBill = Conexion.getConecction();
        String sql = "SELECT COUNT(@@IDENTITY AS id_bill) FROM Bill";
        PreparedStatement ps = null;
        try{
            ps = connBill.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.getInt(1)==1){
                sql = "SELECT @@IDENTITY AS id_bill FROM Bill";
                try{
                    ps = connBill.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rsi = rs.getInt(1);
                }catch(SQLException e){
                    System.err.println(e.getMessage());
                    System.err.println(e.getLocalizedMessage());
                }
                
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.err.println(e.getLocalizedMessage());
        }
        return rsi;
    }
     
     public boolean insertBill(Bill bill){
         String sql = "INSERT INTO Bill (id_client, id_seller) VALUES (?,?)";
         PreparedStatement ps = null;
         try{
             connBill = Conexion.getConecction();
             ps = connBill.prepareStatement(sql);
             ps.setString(1, bill.getClient());
             ps.setString(2,bill.getUser());
             ps.execute();
             return true;
         }catch(SQLException e){
             System.err.println(e);
             return false;
         }
     }
     
     
}
