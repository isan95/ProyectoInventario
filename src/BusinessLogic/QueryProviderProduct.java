/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Conexion;
import Data.ProviderProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author POLANCO
 */
public class QueryProviderProduct {
    private Connection connProviderProduct;
    private ResultSet rs;
    private int cantProviProd;
    
    public boolean insertProviderProduct(ProviderProduct pp){
        String sql = "INSERT INTO provider_product (id_checkin_product,IdProduct, cant_provider_product) VALUES (?,?,?)";
        PreparedStatement ps=null;
        connProviderProduct =Conexion.getConecction();
        try{
            ps = connProviderProduct.prepareStatement(sql);
            ps.setString(1, pp.getCheckInProduct());
            ps.setString(2, pp.getIdProdcut());
            ps.setInt(3, pp.getCant());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                connProviderProduct.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
    } 
}
