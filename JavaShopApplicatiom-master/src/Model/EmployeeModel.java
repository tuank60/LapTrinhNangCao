/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.ArrayList;
import Data.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy.hv150601
 */
public class EmployeeModel extends Employee{
    
    MySqlHandler sql= MySqlHandler.getInstance();
    public ArrayList<Employee> GetAllEmployee(){
        ArrayList<Employee> employees= new ArrayList<>();
        String query= "Select * from Employee";
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            try {
                while (data.next()) {
                     this.setId(data.getInt("Id"));
                     this.setFullname(data.getString("Fullname"));
                     this.setAddress(data.getString("Address"));
                     this.setPhoneNumber(data.getString("PhoneNumber"));
                     this.setUserId(data.getInt("User_Id"));
                     employees.add(this);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return employees;
    }
    public void AddNewEmployee(String Fullname, String Address, String PhoneNumber, String Username){
        String query= "Insert into Employee(Fullname, Address, PhoneNumber, User_id) values"
                + "('"+Fullname+"','"+ Address+"','"+PhoneNumber+"',(Select Id from User where User.Username='"+Username+"');";
        if(sql.connectMySQL()){
            sql.ExecuteQuery(query);
            System.out.println("Success!");
        }
    }
}
