/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Bill;
import Model.BillModel;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class SearchBillController {
    BillModel billModel = new BillModel();
            
    public ArrayList<Bill> getAllBill(){
        return billModel.getAllBill();
    }
    
    public ArrayList<Bill> getBillById(String id){
        return billModel.getBillByID(id);
    }
    
    public ArrayList<Bill> getBillByCustomerID(String customer_id){
        return billModel.getBillByCustomerID(customer_id);
    }
    
}
