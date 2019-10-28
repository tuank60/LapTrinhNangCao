/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class CustomerModel {
    MySqlHandler sql= MySqlHandler.getInstance();
    public boolean checkIfExist(String customerId){

        String query= "Select * from Custommer where Id = '"+ customerId+"'";
        if (sql.connectMySQL()) {
            try {
                ResultSet data= null;
                data= sql.ExecuteSelectQuery(query);
                if (data.next() == true ) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
