/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Data.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duy.hv150601
 */
public class UserModel extends User{
    private final MySqlHandler sql= MySqlHandler.getInstance();
    
    public ArrayList<User> GetAllUsers() throws SQLException{
        String query= "Select * from User";
        
        ArrayList<User> ListUser= new ArrayList<>();
        if (sql.connectMySQL()) {
            ResultSet data= sql.ExecuteSelectQuery(query);
            while (data.next()) { 
                
                User user= new User();
                user.setId(data.getInt("Id"));
                user.setUsername(data.getString("Username"));
                user.setPassword(data.getString("Password"));
                user.setFullname(data.getString("Fullname"));
                user.setAddress(data.getString("Address"));
                user.setPhoneNumber(data.getString("PhoneNumber"));
                user.setRoleId(data.getInt("Role_Id"));
                ListUser.add(user);
            }
        }
        
        sql.CloseConnection();
        return ListUser;
    }
    
    public User SearchUserByUsername(String Username){
        User u= new User();
        u= null;
        if(sql.connectMySQL()){
            ArrayList<User> listUser= new ArrayList<>();
            try {
                listUser= GetAllUsers();
                for(User user: listUser){
                    if(user.getUsername().equals(Username)){
                        u= user;
                    }
                }                
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return u;
    }
    
    
    
    public boolean CreateNewAccount(String Username, String Password, String Fullname, String Address, String PhoneNumber, int RoleId){
        String query= "Insert into User(Username, Password, Fullname, Address, PhoneNumber, Role_Id) values('"+Username+"','"+Password+"','"+ Fullname+"','"+Address+"','"+PhoneNumber+"',"+Integer.toString(RoleId)+")";
        boolean isOk= false;
        if (sql.connectMySQL()) {
            if (this.SearchUserByUsername(Username)== null) {
                sql.ExecuteQuery(query);                
                isOk= true;
            }                        
        }
        sql.CloseConnection();
        return isOk;
    }
    
    public void ChangePassword(String Username, String newPassword){
        String query="Update User set User.Password= '"+newPassword+"' where User.Username= '"+Username+"'";
        if(sql.connectMySQL()){
            sql.ExecuteQuery(query);
            System.out.println("Password was been changed!");
            sql.CloseConnection();
        }
    }
    
    public UserModel getInformation(String Username) throws SQLException{
        String query= "select * from User where User.Username= '"+ Username +"'";
        UserModel userModel= new UserModel();
        if(sql.connectMySQL()){
            
            ResultSet user= sql.ExecuteSelectQuery(query);
            if (user.next()) {
                userModel.setId(user.getInt("Id"));
                userModel.setUsername(user.getString("Username"));
                userModel.setPassword(user.getString("Password"));
                userModel.setFullname(user.getString("Fullname"));
                userModel.setAddress(user.getString("Address"));
                userModel.setPhoneNumber(user.getString("PhoneNumber"));
                userModel.setRoleId(user.getInt("Role_Id"));            
            }

        }
        return userModel;
    }
    public boolean UpdateInformation(String Fullname, String Address, String PhoneNumber, String UserName){
        String query= "Update User set Fullname= '"+Fullname+"', Address= '"+Address+"', PhoneNumber= '"+ PhoneNumber+"' where User.Username= '"+UserName+"'";
        if (sql.connectMySQL()) {
            sql.ExecuteQuery(query);
            System.out.println("Updated!");
            return true;
        }
        return false;
    }
    
    public void UpdateInformationUser(String Fullname, String Address, String PhoneNumber, String UserName, String olUserdName){
        String query= "Update User set Fullname= '"+Fullname+"', Address= '"+Address+"', PhoneNumber= '"+ PhoneNumber+"' , Username= '"+ UserName+"' where User.Username= '"+olUserdName+"'";
        if (sql.connectMySQL()) {
            sql.ExecuteQuery(query);
            System.out.println("Updated!");
        }
    }
    
     public int GetRole(String username) throws SQLException{
        int role = 1;
        String query="Select Role_Id from user Where Username = '"+username+"'";
        if(sql.connectMySQL()){
            ResultSet data= sql.ExecuteSelectQuery(query);
            
            while(data.next()){
                role =data.getInt("Role_Id");
            }
            sql.CloseConnection();
        }
        return role;
    }
}
