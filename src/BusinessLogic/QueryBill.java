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
     
     public ResultSet  getLastIdBill(){
        connBill = Conexion.getConecction();
        PreparedStatement ps = null;
        String sql = "SELECT MAX(id_bill) AS lastIdBill FROM Bill";
                try{
                    ps = connBill.prepareStatement(sql);
                    rs = ps.executeQuery();
                }catch(SQLException e){
                    System.err.println(e.getMessage());
                    System.err.println(e.getLocalizedMessage());
                }
        return rs;
    }
     
     public boolean insertBill(Bill bill){
         String sql = "INSERT INTO Bill (id_client, id_seller,subtotal,iva,total) VALUES (?,?,?,?,?)";
         PreparedStatement ps = null;
         try{
             connBill = Conexion.getConecction();
             ps = connBill.prepareStatement(sql);
             ps.setString(1, bill.getClient());
             ps.setString(2,bill.getUser());
             ps.setInt(3,bill.getSubtotal());
             ps.setInt(4,bill.getIva());
             ps.setInt(5,bill.getTotal());
             ps.execute();
             return true;
         }catch(SQLException e){
             System.err.println(e);
             return false;
         }
     }
     
     
}
