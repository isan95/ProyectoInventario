/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.CheckInProduct;
import Data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author POLANCO
 */
public class QueryCheckInProduct {
    Connection connCheckInProduct;
    ResultSet rs;
    
    public String lastCheckInProduct(){
        connCheckInProduct = Conexion.getConecction();
        String sql = "SELECT MAX(id_checkin_Product) FROM CheckIn_Product";
        PreparedStatement ps = null;
        String documentUser = null;
        try{
            ps = connCheckInProduct.prepareStatement(sql);
            rs = ps.executeQuery();
            try{
                while(rs.next()){
                    documentUser = rs.getString(1);
                }
            }catch(SQLException e){
                System.err.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                connCheckInProduct.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return documentUser;
    }
    
    public boolean insertCheckInProduct(CheckInProduct checkInProduct){
        String sql = "INSERT INTO checkin_product (provider,user_checkin) VALUES (?,?)";
        PreparedStatement ps = null;
        connCheckInProduct = Conexion.getConecction();
        try{
            ps = connCheckInProduct.prepareStatement(sql);
            ps.setString(1, checkInProduct.getProvider());
            ps.setString(2, checkInProduct.getUser());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                connCheckInProduct.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
