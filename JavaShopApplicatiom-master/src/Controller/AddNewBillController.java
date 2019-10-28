/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BillDetailModel;
import Model.BillModel;
import Model.CustomerModel;
import Model.ProductModel;

/**
 *
 * @author lenovo
 */
public class AddNewBillController {
    public boolean checkIfExistCustomer(String customerId){
        CustomerModel customerModel = new CustomerModel();
        return customerModel.checkIfExist(customerId);
    }
    
    public void addNewBill(int totalPrice, String time, int userId, int customerId) {
        BillModel billModel = new BillModel();
        billModel.Add(totalPrice,time,userId,customerId);
    }
    
    public int getBillId(String time){
        BillModel billModel = new BillModel();
        return billModel.getBillId(time);
    }
    
    public void addNewBillDetail(int billId,int number, int price, int productId){
        BillDetailModel billDetailModel = new BillDetailModel();
        billDetailModel.Add(billId,number,price,productId);
    }
    
    public boolean checkIfEnoughGood(int productId, int numberWantToBuy) {
        ProductModel productModel = new ProductModel();
        return productModel.checkIfEnoughGood(productId, numberWantToBuy);
    }
    
    public void updateStorage(int productId, int numberToBuy) {
        ProductModel productModel = new ProductModel();
        productModel.updateStorage(productId, numberToBuy);
    }
}
