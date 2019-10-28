/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.MyConnect;
import java.lang.NullPointerException;
import Model.QuanLy;


/**
 *
 * @author DO ANH TUAN
 */
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
        sqlCommand = "SELECT * FROM quanlybanhang.QuanLy WHERE TaiKhoan = '" + name + "' AND MatKhau = '" + password + "'";
        try {
            st = myConn.getConnection().createStatement();
            System.out.println(st);
            rs = st.executeQuery(sqlCommand);
            if (rs.next()) {
                return true;
            }
        } catch (IOException | SQLException e) {
        } finally {
            myConn.getConnection().close();
        }

        return false;
    }
}
