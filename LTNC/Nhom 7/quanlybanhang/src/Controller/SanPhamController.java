/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SanPham;
import Model.MyConnect;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DO ANH TUAN
 */
public class SanPhamController {
    private MyConnect myConn;
    private ArrayList<SanPham> listSanPham;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String sqlCommand;
    private String sqlCommand1;
    private String sqlCommand2;
    private String sqlCommand3;
    private String sqlCommand4;
    private SanPham sanPham;
    
    public SanPhamController() {
        myConn = new MyConnect();
    }

    public ArrayList<SanPham> getListSanPham(String MaSP, String TenSP,int HangSP) throws SQLException, IOException {
        listSanPham = new ArrayList<SanPham>();
        st = null;
        rs = null;
        sqlCommand1 = "select * from SanPham";
        sqlCommand2 = "select * from SanPham where MaSP = " + MaSP;
        sqlCommand3 = "select * from SanPham where TenSP = '" + TenSP + "'";
        sqlCommand4 = "select * from SanPham where HangSP = '" + HangSP + "'";
        try {
            st = myConn.getConnection().createStatement();
            if (MaSP != "") {
                sqlCommand = sqlCommand2;
            } else if (TenSP != "") {
                sqlCommand = sqlCommand3;
            } else if (HangSP != 0) {
                sqlCommand = sqlCommand4;
            } else {
                sqlCommand = sqlCommand1;
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                sanPham = new SanPham(rs.getString("MaSP"), rs.getString("TenSP"), rs.getInt("HangSP"), rs.getDate("NSX"),rs.getString("GiaTien"));
                listSanPham.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }

        return listSanPham;
    }
    public void show_SanPham_On_JTable(ArrayList<SanPham> listSanPham, DefaultTableModel model) {
        Object[] row = new Object[7];
        for (int i = 0; i < listSanPham.size(); i++) {
            row[0] = listSanPham.get(i).getMaSP();
            row[1] = listSanPham.get(i).getTenSP();
            row[2] = listSanPham.get(i).getHangSP();
            row[3] = listSanPham.get(i).getNSX();
            row[4] = listSanPham.get(i).getGiaTien();
            //row[5] = listSanPham.get(i).getEmail();
            model.addRow(row);
        }
    }
    
    public boolean deleteSanPham(String MaSP) {
        try {
            sqlCommand = "DELETE FROM quanlybanhang.SanPham WHERE MaSP = ?";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setString(1, MaSP);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addSP(String TenSP, String MaSP, String HangSX, Date NgaySX, String GiaTien) {

        try {
            //Thêm một sản phẩm vào trong cơ sở dữ liệu
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String vNSX = dateFormat.format(NgaySX);
            sqlCommand = "INSERT INTO quanlybanhang.SanPham(MaSP, TenSP, HangSP, NSX, GiaTien)  VALUES (?, ?, ?, ?, ?)";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setString(1, MaSP);
            ps.setString(2, TenSP);
            ps.setString(3, HangSX);
            ps.setString(4, vNSX);
            ps.setString(5, GiaTien);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSanPham(String MaSP, String TenSP, String HangSX, Date ngaySX, String giaTien) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String vSX = dateFormat.format(ngaySX);
            sqlCommand = "UPDATE quanlybanhang.SanPham set TenSP= '" + TenSP + "', HangSP= '" + HangSX + "', NSX= '" + vSX + "', GiaTien= '" + giaTien + "' WHERE MaSP ='" + MaSP + "'";
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
