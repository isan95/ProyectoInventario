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

    public boolean insertProduct(Product pro) {
        PreparedStatement pqp = null;
        this.conProduct = Conexion.getConecction();
        String sql = "INSERT INTO product (idProduct,nameProduct,description,price,unitMeasurement,stock) VALUES (?,?,?,?,?,?)";
        try {
            pqp = conProduct.prepareStatement(sql);
            pqp.setString(1, pro.getIdProduct());
            pqp.setString(2, pro.getNameProduct());
            pqp.setString(3, pro.getDescription());
            pqp.setInt(4, pro.getPrice());
            pqp.setString(5, pro.getUnitMeasure());
            pqp.setInt(6, pro.getStock());
            pqp.execute();
            return true;

        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                conProduct.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }

    public ResultSet getProducts() {
        PreparedStatement pqp = null;
        this.conProduct = Conexion.getConecction();
        String sql = "SELECT idProduct, nameProduct, description, price, unitMeasurement, stock FROM product";
        try {
            pqp = conProduct.prepareStatement(sql);
            rs = pqp.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantProduct = rsMd.getColumnCount();

        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }
    public ResultSet getProductsIn(String attribute, String value){
        PreparedStatement pqp = null;
        this.conProduct = Conexion.getConecction();
        String sql=null;
        if(attribute.equals("Codigo")){
            sql = "SELECT idproduct, nameProduct, description, unitMeasurement FROM product WHERE IdProduct LIKE '"+value+"%'";
        }
        else{
            if(attribute.equals("Nombre")){
                sql = "SELECT idproduct, nameProduct, description, unitMeasurement FROM product WHERE nameProduct LIKE '"+value+"%'";
            }
        }
        
        try{
            pqp = conProduct.prepareStatement(sql);
            rs = pqp.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            cantProduct = rsMd.getColumnCount();
        }catch(SQLException e){
            System.err.println(e);
        }
        return rs;
    }

    public void closeConnection() {
        try {
            this.conProduct.close();
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public ResultSet getProductForWhere(String attribute, String value) {
        PreparedStatement pqw = null;
        String sql = null;
        this.conProduct = Conexion.getConecction();
        if (attribute.equals("Nombre")) {
            sql = "SELECT * FROM Product WHERE nameProduct LIKE" + "'" + value + "%'";
        } else {
            if (attribute.equals("Codigo")) {
                sql = "SELECT * FROM Product WHERE idProduct LIKE" + "'" +value+"%'";
            }
        }
        try {
            pqw = this.conProduct.prepareStatement(sql);
            rs = pqw.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            cantProduct = rsMd.getColumnCount();
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public boolean updateProduct(Product pro, String idProduct) {
        PreparedStatement pqu = null;
        boolean updated = false;

        String sql = "UPDATE product SET nameProduct = ?, description = ?, price = ?, unitMeasurement = ?, stock = ? WHERE IdProduct = '" + idProduct + "'";
        try {
            this.conProduct = Conexion.getConecction();
            pqu = this.conProduct.prepareStatement(sql);
            pqu.setString(1, pro.getNameProduct());
            pqu.setString(2, pro.getDescription());
            pqu.setInt(3, pro.getPrice());
            pqu.setString(4, pro.getUnitMeasure());
            pqu.setInt(5, pro.getStock());
            pqu.execute();
            updated = true;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return updated;
    }

    public boolean deleteProduct(String idProduct) {
        PreparedStatement pqu = null;
        boolean delete = false;
        String sql = "DELETE  FROM product WHERE IdProduct = '" + idProduct + "'";
        try {
            this.conProduct = Conexion.getConecction();
            pqu = this.conProduct.prepareStatement(sql);
            pqu.execute();
            delete = true;
        } catch (SQLException e) {
            System.err.print(e);
        }

        return delete;
    }

}
