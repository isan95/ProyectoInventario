/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author POLANCO
 */
public class Conexion {
    private static final String nameDb="login";
    private static final String userDb="root";
    private static final String passwordDb="";
    private static final String urlDb="jdbc:mysql://localhost:3306/"+nameDb;
    private static Connection conDb = null;
    
    public static Connection getConecction(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           conDb = (Connection)DriverManager.getConnection(Conexion.urlDb, Conexion.userDb, Conexion.passwordDb);
        }catch(SQLException e){
            System.err.print(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Conexion.conDb;
    }
    
}
