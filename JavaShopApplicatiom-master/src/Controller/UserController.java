/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.UserModel;
import Data.User;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Duy.hv150601
 */
public class UserController {
    private final UserModel userModel= new UserModel();
    public boolean Login(String Username, String Password){
        if (userModel.SearchUserByUsername(Username)!= null) {
            if(userModel.SearchUserByUsername(Username).getPassword().equals(Password))
                return true;
        }   
        return false;
    }
    public ArrayList<User> GetAllUser() throws SQLException{
        return userModel.GetAllUsers();
    }
    public boolean CreateNewAccount(String Username, String Password, String Fullname, String Address, String PhoneNumber){
        return userModel.CreateNewAccount(Username, Password, Fullname, Address, PhoneNumber, 3)== true;
    }
    public void ChangePassword(String Username, String newPassword, String OldPassword){
        userModel.ChangePassword(Username, newPassword);
    }
    
    public UserModel getInformation(String Username) throws SQLException{
        UserModel user= new UserModel();
        user= userModel.getInformation(Username);
        return user;
    }
    public boolean UpdateInformation(String Fullname, String Address, String PhoneNumber, String Username){
        if (userModel.UpdateInformation(Fullname, Address, PhoneNumber, Username)) {
            return true;
        }
        return false;
    }
    
    public void UpdateInformationUser(String Fullname, String Address, String PhoneNumber, String UserName,String oldUsername)
    {
        userModel.UpdateInformationUser(Fullname, Address, PhoneNumber, UserName, oldUsername);
    }
    
    public int GetRole(String username) throws SQLException{
        int role;
        role = userModel.GetRole(username);
        return role;
    }
}
