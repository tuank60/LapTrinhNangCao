/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Data.Bill;
import Data.Employee;
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
public class BillModel extends Bill{
    MySqlHandler sql= MySqlHandler.getInstance();
    public ArrayList<Bill> getAllBill(){
        ArrayList<Bill> bills= new ArrayList<>();
        String query= "Select * from Bill";
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            try {
                while (data.next()) {
                    Bill bill = new Bill();
                     bill.setId(data.getInt("Id"));
                     bill.setCustommerId(data.getInt("Custommer_Id"));
                     bill.setTotalPrice(data.getInt("Total_price"));
                     bill.setUserId(data.getInt("User_Id"));
                     bill.setTime(data.getString("Time"));
                     bills.add(bill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bills;
    }
    
    public int getBillId (String time){
        String query= "Select Id from Bill where Time = '"+time+"'";
        int billId = 0;
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            
            try {
                while (data.next()) {
                    billId = data.getInt("Id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return billId;
    }
    
    public ArrayList<Bill> getBillByID (String bill_id){
        String query= "Select * from Bill where Id = '"+bill_id+"'";
        ArrayList<Bill> bills = new ArrayList<Bill>();
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            
            try {
                while (data.next()) {
                    Bill bill = new Bill();
                     bill.setId(data.getInt("Id"));
                     bill.setCustommerId(data.getInt("Custommer_Id"));
                     bill.setTotalPrice(data.getInt("Total_price"));
                     bill.setUserId(data.getInt("User_Id"));
                     bill.setTime(data.getString("Time"));
                     bills.add(bill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bills;
    }
    
    public ArrayList<Bill> getBillByCustomerID(String customer_id){
        String query= "Select * from Bill where Custommer_Id = '"+customer_id+"'";
        ArrayList<Bill> bills = new ArrayList<Bill>();
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            
            try {
                while (data.next()) {
                    Bill bill = new Bill();
                     bill.setId(data.getInt("Id"));
                     bill.setCustommerId(data.getInt("Custommer_Id"));
                     bill.setTotalPrice(data.getInt("Total_price"));
                     bill.setUserId(data.getInt("User_Id"));
                     bill.setTime(data.getString("Time"));
                     bills.add(bill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bills;
    }
    public void Add(int Total_price, String Time, int User_Id, int Customer_Id){
        String query= "Insert into Bill(Total_price, Time, User_id,Custommer_Id) values"
                + "('"+ Total_price+"','"+Time+"','"+User_Id+"','"+Customer_Id+"');";
        if(sql.connectMySQL()){
            sql.ExecuteQuery(query);
            System.out.println("Success!");
        }
    }
}
