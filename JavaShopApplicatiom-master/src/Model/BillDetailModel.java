/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Data.Bill;
import Data.BillDetail;
import Model.EmployeeModel;
import Model.MySqlHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class BillDetailModel extends BillDetail{
    MySqlHandler sql= MySqlHandler.getInstance();
    public ArrayList<BillDetail> getAllBillDetail(){
        ArrayList<BillDetail> billdetails= new ArrayList<>();
        String query= "Select * from BillDetailModel";
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            try {
                while (data.next()) {
                    BillDetail billDetail = new BillDetail();
                     billDetail.setId(data.getInt("Id"));
                     billDetail.setNumber(data.getInt("Number"));
                     billDetail.setPrice(data.getInt("Price"));
                     billDetail.setProductId(data.getInt("Product_Id"));
                    
                     billdetails.add(billDetail);
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return billdetails;
    }
    public void Add(int Id, int Number, int Price, int Product_Id){
        String query= "Insert into bill_detail(Id, Number,Price,Product_Id) values"
                + "('"+Id+"','"+Number+"','"+Price+"','"+Product_Id+"');";
        if(sql.connectMySQL()){
            sql.ExecuteQuery(query);
            System.out.println("Success!");
        }
    }
    
}

    