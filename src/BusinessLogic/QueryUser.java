/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Conexion;
import Data.Product;
import Data.User;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author POLANCO
 */
public class QueryUser {

    private Connection conController;
    private ResultSet rs;
    private int cantUser;

    public int getCantUser() {
        return cantUser;
    }

    public void setCantUser(int cantUser) {
        this.cantUser = cantUser;
    }

    public ResultSet getUser() {
        PreparedStatement pqg = null;
        rs = null;
        this.conController = Conexion.getConecction();
        String sql = "SELECT Nick, Nombre, Primer_apellido, Segundo_apellido, Rol FROM userinventario";
        try {
            pqg = this.conController.prepareStatement(sql);
            rs = pqg.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.cantUser = rsMd.getColumnCount();

        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public boolean insertUser(User usr) {
        PreparedStatement pqi = null;
        Connection conControllerI = Conexion.getConecction();
        String sql = "INSERT INTO userinventario (Nick,Nombre,Password,Primer_apellido, Segundo_apellido, Rol) VALUES (?,?,?,?,?,?)";
        try {
            pqi = conControllerI.prepareStatement(sql);
            pqi.setString(1, usr.getNick());
            pqi.setString(2, usr.getName());
            pqi.setString(3, DigestUtils.sha1Hex(usr.getPassword()));
            pqi.setString(4, usr.getpApellido());
            pqi.setString(5, usr.getsApellido());
            pqi.setInt(6, usr.getRol());
            pqi.execute();
            return true;
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                conControllerI.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }

    public boolean login(User usr) {
        PreparedStatement pqg = null;
        rs = null;
        boolean found = false;
        Connection conControllerG = Conexion.getConecction();
        String sql = "SELECT Nick, Password, Rol FROM userinventario WHERE Nick=?";
        try {
            pqg = conControllerG.prepareStatement(sql);
            pqg.setString(1, usr.getNick());
            rs = pqg.executeQuery();

            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(2)) && usr.getRol() == rs.getInt(3)) {
                    usr.setNick(rs.getString(1));
                    usr.setPassword(rs.getString(2));
                    usr.setRol(rs.getInt(3));
                    found = true;
                }
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            try {
                conControllerG.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
        return found;
    }

    public void closeConnectionUser() {
        try {
            this.conController.close();
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public ResultSet getUserForWhere(String attribute, String value) {
        PreparedStatement pqw = null;
        String sql = null;
        this.conController = Conexion.getConecction();
        switch (attribute) {
            case "Nombre":
                sql = "SELECT Nick, Nombre, Primer_apellido, Segundo_apellido, Rol FROM userinventario WHERE Nombre" + " = '" + value + "'";
                break;
            case "Apellido":
                sql = "SELECT Nick, Nombre, Primer_apellido, Segundo_apellido, Rol FROM userinventario WHERE Primer_apellido" + " = '" + value + "' OR Segundo_apellido = '" + value + "'";
                break;
            case "Nick":
                sql = "SELECT Nick, Nombre, Primer_apellido, Segundo_apellido, Rol FROM userinventario WHERE Nick" + " = '" + value + "'";
                break;
            case "Rol":
                sql = "SELECT Nick, Nombre, Primer_apellido, Segundo_apellido, Rol FROM userinventario WHERE Rol" + " = '" + Integer.parseInt(value) + "'";
                break;
        }

        try {
            pqw = this.conController.prepareStatement(sql);
            rs = pqw.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantUser = rsMd.getColumnCount();
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public boolean updateUser(User usr) {
        PreparedStatement pqu = null;
        boolean updated = false;

        String sql = "UPDATE userinventario SET Nick = ?, Password = ?, Nombre = ?,Primer_apellido = ?, Segundo_apellido = ?, rol = ? WHERE Nick = '" + usr.getNick() + "'";
        try {
            this.conController = Conexion.getConecction();
            pqu = this.conController.prepareStatement(sql);
            pqu.setString(1, usr.getNick());
            pqu.setString(3, usr.getName());
            pqu.setString(4, usr.getpApellido());
            pqu.setString(5, usr.getsApellido());
            pqu.setInt(6, usr.getRol());
            pqu.setString(2, DigestUtils.sha1Hex(usr.getPassword()));
            pqu.execute();
            updated = true;
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            try {
                conController.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
        return updated;
    }

    public boolean deleteUser(String nick) {
        PreparedStatement pqu = null;
        boolean delete = false;
        String sql = "DELETE  FROM userinventario WHERE Nick = '" + nick + "'";
        try {
            this.conController = Conexion.getConecction();
            pqu = this.conController.prepareStatement(sql);
            pqu.execute();
            delete = true;
        } catch (SQLException e) {
            System.err.print(e);
        }

        return delete;
    }
}
