/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Employee;
import Model.EmployeeModel;
import java.util.ArrayList;

/**
 *
 * @author Duy.hv150601
 */
public class EmployeeController {
    EmployeeModel employeeModel= new EmployeeModel();
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> employees= new ArrayList<>(employeeModel.GetAllEmployee());
        return employees;
    }
    public void AddNewEmployee(String Fullname, String Address, String PhoneNumber, String Username){
        employeeModel.AddNewEmployee(Fullname, Address, PhoneNumber, Username);
    }
}
