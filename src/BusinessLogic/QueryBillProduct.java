/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;
import Data.BillProduct;
import Data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author POLANCO
 */
public class QueryBillProduct {
    private Connection connBillProduct;
    private ResultSet rs;
    
    public boolean insertBillProduc(BillProduct bp){
        String sql = "INSERT INTO Bill_product (ID_BILL, IDPRODUCT) VALUES (?,?)";
        PreparedStatement ps;
        try{
            connBillProduct = Conexion.getConecction();
            ps = connBillProduct.prepareStatement(sql);
            ps.setInt(1,bp.getNBill());
            ps.setString(2, bp.getIdProduct());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.err.println(e.getLocalizedMessage());
            return false;
        }
    }
}
