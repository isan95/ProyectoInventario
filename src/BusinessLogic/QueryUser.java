/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Conexion;
import Data.User;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author POLANCO
 */
public class QueryUser {
    private Connection conController;
    private ResultSet rs;
    
    public boolean getUser(User usr){
    PreparedStatement pqg= null;
    rs = null;
    boolean found = false;
    Connection conControllerG= Conexion.getConecction();
    String sql = "SELECT * FROM user WHERE Nick=?";
    try{
        pqg = conControllerG.prepareStatement(sql);
        pqg.setString(1,usr.getNick());
        rs = pqg.executeQuery();
    
        if(rs.next()){
            usr.setNick(rs.getString("Nick"));
            usr.setPassword(rs.getString("Password"));
            found=true;
        }
    }catch(SQLException e){
        System.err.print(e);
    } 
    return found;
    }
    
    public boolean insertUser(User usr){
        PreparedStatement pqi= null;
        Connection conControllerI = Conexion.getConecction();
        String sql="INSERT INTO user (Nick,Password) VALUES (?,?)";
        try{
            pqi = conControllerI.prepareStatement(sql);
            pqi.setString(1, usr.getNick());
            pqi.setString(2,usr.getPassword()); 
            pqi.execute();
            return true;
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }finally{
            try{
                conControllerI.close();
            }
            catch(SQLException e){
                System.err.print(e);
    }
        }
    }
    
    public boolean login(User usr){
    PreparedStatement pqg= null;
    rs = null;
    boolean found = false;
    Connection conControllerG= Conexion.getConecction();
    String sql = "SELECT * FROM user WHERE Nick=?";
    try{
        pqg = conControllerG.prepareStatement(sql);
        pqg.setString(1,usr.getNick());
        rs = pqg.executeQuery();
    
        if(rs.next()){
            if(usr.getPassword().equals(rs.getString(2))){
                usr.setNick(rs.getString(1));
                usr.setPassword(rs.getString(2));
                found=true;
            }
        }
    }catch(SQLException e){
        System.err.print(e);
    } 
    return found;
    }
  
    
}
