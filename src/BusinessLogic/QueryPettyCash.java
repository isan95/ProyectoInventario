/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Conexion;
import Data.PettyCash;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author POLANCO
 */
public class QueryPettyCash {
    private Connection connPettyCash;
    private ResultSet rs;
    
    public boolean insertPettyCash(PettyCash pc){
        connPettyCash = Conexion.getConecction();
        PreparedStatement ps = null;
        try{
            String sql = "INSERT INTO petty_cash (cash,reason,user_petty_cash) VALUES(?,?,?)";
            ps = connPettyCash.prepareStatement(sql);
            ps.setInt(1, pc.getCash());
            ps.setString(2, pc.getReason());
            ps.setString(3, pc.getUser());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                connPettyCash.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
