/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Data.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Shady
 */
public class ProductModel {
    private final MySqlHandler sql=MySqlHandler.getInstance();
    
    public Boolean _isHad;
    
    public ArrayList<Product> GetAllProduct() throws SQLException{
        String query= "Select * from Product";
        ArrayList<Product> ListProduct= new ArrayList<>();
        if (sql.connectMySQL()) {
            ResultSet data= sql.ExecuteSelectQuery(query);
            while (data.next()) {                
                Product product= new Product();
                product.setId(data.getInt("Id"));
                product.setName(data.getString("Name"));
                product.setNumber(data.getInt("Number"));
                product.setPrice(data.getInt("Price"));
                product.setDetail(data.getString("Detail"));
                ListProduct.add(product);
            }
        }
        sql.CloseConnection();
        return ListProduct;
    }
    
    public ArrayList<Product> SearchProductByName(String name){
        ArrayList<Product> listSearchProduct= new ArrayList<>();
        if(sql.connectMySQL()){
            ArrayList<Product> listProduct= new ArrayList<>();
            try {
                listProduct= GetAllProduct();
                for( Product pro: listProduct){
                    if(pro.getName().equals(name)){
                        listSearchProduct.add(pro);
                    }
                }                
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return listSearchProduct;
    }
    
    
    public void DeleteProduct(int id)
    {
        String query="Delete from Product where Id='"+id+"';";
        if(sql.connectMySQL())
        {
            sql.ExecuteQuery(query);
        }
        sql.CloseConnection();
    }
    
    public void UpdateProduct(String name,int number,int price,String detail,int idtest)
    {
        _isHad=false;
        String query="UPDATE Product SET Name='"+name+"',Number="+Integer.toString(number)+",Price="+Integer.toString(price)+",Detail='"+detail+"' WHERE (Id= "+Integer.toString(idtest)+");";
        if(sql.connectMySQL())
        {
            
            if(this.SearchProductByName(name)!=null)
            {
                int d=0;
                for(Product p:this.SearchProductByName(name))
                {
                    if(p.getId()!=idtest&&(p.getDetail().trim().equalsIgnoreCase(detail.trim())&&p.getPrice()==price))
                    {
                        d++;
                    }
                }
                if(d!=0)
                {
                    System.err.println("Sản phẩm đã có trong danh sách sản phẩm!");
                    JOptionPane.showMessageDialog(null, "Sản phẩm đã có trong danh sách!");
                    _isHad=true;
                }
            }
            else
            if (this.SearchProductByName(name)== null) {
                _isHad=false;
            }
        
            if(_isHad==false)
                sql.ExecuteQuery(query);  
        }
        sql.CloseConnection();
    }
    
    public void CreateNewProduct(String name,int number,int price,String detail){
        _isHad=false;
        String query= "Insert into Product(Name,Number,Price,Detail) values('"+name+"',"+Integer.toString(number)+","+Integer.toString(price)+",'"+detail+"')";
        if (sql.connectMySQL()) {
            
            if(this.SearchProductByName(name)!=null)
            {
                int d=0;
                for(Product p:this.SearchProductByName(name))
                {
                    if(p.getDetail().trim().equalsIgnoreCase(detail.trim())&&p.getPrice()==price)
                    {
                        d++;
                    }
                }
                if(d!=0)
                {
                    System.err.println("Sản phẩm đã có trong danh sách sản phẩm!");
                    JOptionPane.showMessageDialog(null, "Sản phẩm đã có trong danh sách!");
                    _isHad=true;
                }
            }
            else
            if (this.SearchProductByName(name)== null) {
                _isHad=false;
            }
            
            if(!_isHad)
                sql.ExecuteQuery(query);  
            
        }
        sql.CloseConnection();
    }
    
    public boolean checkIfEnoughGood(int productId, int numberWantToBuy){
        String query= "Select * from Product where Id = '"+productId+"'";
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            try {
                while (data.next()) {
                    int number = data.getInt("Number");
                    if (number < numberWantToBuy) {
                        return false;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    public int getNumberInStorage(int productId) {
        String query= "Select * from Product where Id = '"+productId+"'";
        int numberInStorage = 0;
        if (sql.connectMySQL()) {
            ResultSet data= null;
            data= sql.ExecuteSelectQuery(query);
            try {
                while (data.next()) {
                    numberInStorage = data.getInt("Number");
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return numberInStorage;
    }
    
    public void updateStorage(int productId, int numberToBuy){
        int newValue = getNumberInStorage(productId) - numberToBuy;
        String query = "UPDATE Product SET Number = '"+newValue+"' WHERE Id = '"+productId+"';";
        if (sql.connectMySQL()) {
            sql.ExecuteQuery(query);
            System.out.println("Update storage success");
        }
    } 
}
