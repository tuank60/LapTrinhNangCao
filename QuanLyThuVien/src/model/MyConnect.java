
package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnect {
    private String className;
    private String url;
    private String user;
    private String password;
    
    public Connection getConnection() throws IOException{
        Connection conn;
        
        className = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/quanlybanhang?verifyServerCertificate=false&useSSL=true";
        user = "root";
        password = "root";
        
        try {
            // Khai báo tên driver (tên Class) để kết nối với hệ quản trị cơ sở dữ liệu MYSQL
            Class.forName(className);
            // Lấy về kết nối
            conn =DriverManager.getConnection(url,user,password); 
            return conn;
        } catch (Exception e) {
            // Ket noi khong thanh cong, hien thi loi
            e.printStackTrace();
            System.err.println("ketnoikhongthanh");
        }
        return null;
    }
    
}
