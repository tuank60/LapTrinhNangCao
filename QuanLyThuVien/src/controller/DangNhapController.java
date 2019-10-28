/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.MyConnect;
import model.ThuThu;

public class DangNhapController {

    private MyConnect myConn;
    private Statement st;
    private ResultSet rs;
    private String sqlCommand;

    public DangNhapController() {
        myConn = new MyConnect();
    }

    public boolean isExistedAccount(String name, String password) throws IOException, SQLException {
        st = null;
        rs = null;
        sqlCommand = "SELECT * FROM quanlythuvien.thuthu WHERE tendangnhap = '" + name + "' AND matkhau = '" + password + "'";
        try {
            System.out.println("aa");
            st = myConn.getConnection().createStatement();
            rs = st.executeQuery(sqlCommand);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }

        return false;
    }
}
