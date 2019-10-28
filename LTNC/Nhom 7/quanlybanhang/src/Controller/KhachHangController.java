/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Model.Khachhang;
import Model.MyConnect;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.Home;
/**
 *
 * @author DO ANH TUAN
 */
public class KhachHangController {
    private MyConnect myConn;
    private ArrayList<Khachhang> listKhachHang;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String sqlCommand;
    private String sqlCommand1;
    private String sqlCommand2;
    private String sqlCommand3;
    private Khachhang KhachHang;
    
    public KhachHangController() {
        myConn = new MyConnect();
    }

    public ArrayList<Khachhang> getListKhachhang(String MaKH, String TenKH) throws SQLException, IOException {
        listKhachHang = new ArrayList<Khachhang>();
        st = null;
        rs = null;
        sqlCommand1 = "select * from KhachHang";
        sqlCommand2 = "select * from KhachHang where MaKH = " + MaKH;
        sqlCommand3 = "select * from KhachHang where TenKH = '" + TenKH + "'";
        
        try {
            st = myConn.getConnection().createStatement();
            if (MaKH != "") {
                sqlCommand = sqlCommand2;
            } else if (TenKH != "") {
                sqlCommand = sqlCommand3;
            } else {
                sqlCommand = sqlCommand1;
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                KhachHang = new Khachhang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getDate("NgaySinh"), rs.getString("SDT"),rs.getString("QueQuan"),rs.getString("Email"));
                listKhachHang.add(KhachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }

        return listKhachHang;
    }
    public void show_KhachHang_On_JTable(ArrayList<Khachhang> listKhachHang, DefaultTableModel model) {
        Object[] row = new Object[7];
        for (int i = 0; i < listKhachHang.size(); i++) {
            row[0] = listKhachHang.get(i).getMaKH();
            row[1] = listKhachHang.get(i).getTenKH();
            row[2] = listKhachHang.get(i).getNgaySinh();
            row[3] = listKhachHang.get(i).getSDT();
            row[4] = listKhachHang.get(i).getQueQuan();
            row[5] = listKhachHang.get(i).getEmail();
            model.addRow(row);
        }
    }
    
    public boolean deleteKhachHang(String MaKH) {
        try {
            sqlCommand = "DELETE FROM quanlybanhang.KhachHang WHERE MaKH = ?";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setString(1, MaKH);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isExistedKhachhang(String MaKH, String TenKH) throws IOException, SQLException {
        st = null;
        rs = null;
        sqlCommand1 = "select * from KhachHang";
        sqlCommand2 = "select * from KhachHang where MaKH = " + MaKH;
        sqlCommand3 = "select * from KhachHang where TenKH = '" + TenKH + "'";
        
        try {
            st = myConn.getConnection().createStatement();
            if (MaKH != "") {
                sqlCommand = sqlCommand2;
            } else if (TenKH != "") {
                sqlCommand = sqlCommand3;
            } else {
                sqlCommand = sqlCommand1;
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }

        return false;
    }
    
    public boolean AddKhachhang(String MaKH, String TenKH, Date NgaySinh, String SDT, String QueQuan, String Email){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String vNS = dateFormat.format(NgaySinh);
            sqlCommand = "INSERT INTO quanlybanhang.KhachHang(MaKH, TenKH, NgaySinh, SDT, QueQuan ,Email)  VALUES (?, ?, ?, ?, ?, ?)";
            
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setString(1, MaKH);
            ps.setString(2, TenKH);
            ps.setString(3,vNS);
            ps.setString(4, SDT);
            ps.setString(5, QueQuan);
            ps.setString(6, Email);
            ps.executeUpdate();
            ps.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }
    public boolean updateKhachhang(String MaKH, String TenKH, Date NgaySinh, String SDT,String QueQuan, String Email){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String vNS = dateFormat.format(NgaySinh);
            String sqlCommand = "UPDATE quanlybanhang.KhachHang set TenKH= '" + TenKH + "', NgaySinh= '" + vNS + "', SDT= '" + SDT + "', QueQuan= '" + QueQuan + "', Email = '" + Email + "' WHERE MaKH ='" + MaKH + "'";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
