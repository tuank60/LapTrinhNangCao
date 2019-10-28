/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Data.Product;
import Model.ProductModel;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Shady
 */
public class ProductController {
    private final ProductModel proModel=new ProductModel();
    
    public ArrayList<Product> getAllProduct() throws SQLException
    {
        return proModel.GetAllProduct();
    }
    
    public ArrayList<Product> searchByName(String name)
    {
        return proModel.SearchProductByName(name);
    }
    
    public void InsertProduct(String name,int number,int price,String detail)
    {
        proModel.CreateNewProduct(name, number, price, detail);
    }
    
    public void UpdateProduct(String name,int number,int price,String detail,int idtest)
    {
        proModel.UpdateProduct(name, number, price, detail,idtest);
    }
    public void DeleteProduct(int id)
    {
        proModel.DeleteProduct(id);
    }
    
    public Boolean IsHad()
    {
        return proModel._isHad;
    }
    
}
