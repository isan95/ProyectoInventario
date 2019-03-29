/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Conexion;
import Data.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author POLANCO
 */
public class QueryProduct {
    Connection conProduct;
    ResultSet rs;
    int cantProduct;

    public int getCantProduct() {
        return cantProduct;
    }   
    
    public boolean insertProduct(Product pro){
        PreparedStatement pqp = null;
        this.conProduct = Conexion.getConecction();
        String sql = "INSERT INTO product (idProduct,nameProduct,description,price,unitMeasurement,stock) VALUES (?,?,?,?,?,?)";
        try{
            pqp = conProduct.prepareStatement(sql);
            pqp.setString(1,pro.getIdProduct());
            pqp.setString(2,pro.getNameProduct());
            pqp.setString(3,pro.getDescription());
            pqp.setInt(4,pro.getPrice());
            pqp.setString(5,pro.getUnitMeasure());
            pqp.setInt(6,pro.getStock());
            pqp.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }finally{
        try{
        conProduct.close();
        }catch(SQLException e){
        System.err.print(e);
        }
    }
    }
    
    public ResultSet getProducts(){
        PreparedStatement pqp = null;
        this.conProduct = Conexion.getConecction();
        String sql = "SELECT idProduct, nameProduct, description, price, unitMeasurement, stock FROM product";
        try{
            pqp = conProduct.prepareStatement(sql);
            rs = pqp.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantProduct = rsMd.getColumnCount();
                        
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }
    
    public void closeConnection(){
        try{
            this.conProduct.close();
        }
        catch(SQLException e){
            System.err.print(e);
        }
    }
    
    public ResultSet getProductForWhere(String attribute, String value){
        PreparedStatement pqw = null;
        String sql = null;
        this.conProduct = Conexion.getConecction();
        if(attribute.equals("Nombre")){
             sql = "SELECT * FROM Product WHERE nameProduct"+" = '"+value+"'";
            }
        else{
            if(attribute.equals("Codigo")){
                sql = "SELECT * FROM Product WHERE idProduct"+" = "+Integer.parseInt(value);
            }
        }
        try{
            pqw = this.conProduct.prepareStatement(sql);
            rs = pqw.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantProduct = rsMd.getColumnCount();
        }catch(SQLException e){
            System.err.print(e);
        }
        return rs;
    }
}
