package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.MyConnect;
import model.Sach;

public class SachController {

    private MyConnect myConn;
    private ArrayList<Sach> listSach;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String sqlCommand;
    private String sqlCommand1;
    private String sqlCommand2;
    private String sqlCommand3;
    private String sqlCommand4;
    private Sach sach;

    public SachController() {
        myConn = new MyConnect();
    }

    public ArrayList<Sach> getListSach(int maSach, String tenSach, String tacGia) throws SQLException, IOException {
        listSach = new ArrayList<Sach>();
        st = null;
        rs = null;
        sqlCommand1 = "select * from sach";
        sqlCommand2 = "select * from sach where masach = " + maSach;
        sqlCommand3 = "select * from sach where tensach = '" + tenSach + "'";
        sqlCommand4 = "select * from sach where tacgia = '" + tacGia + "'";
        try {
            st = myConn.getConnection().createStatement();
            if (maSach != 0) {
                sqlCommand = sqlCommand2;
            } else if (tenSach != "") {
                sqlCommand = sqlCommand3;
            } else if (tacGia != "") {
                sqlCommand = sqlCommand4;
            } else {
                sqlCommand = sqlCommand1;
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                sach = new Sach(rs.getInt("masach"), rs.getString("tensach"), rs.getString("theloai"), rs.getString("tacgia"), rs.getString("nhaxuatban"), rs.getInt("namxuatban"), rs.getInt("giatien"));
                listSach.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }

        return listSach;
    }

    public void show_Sach_On_JTable(ArrayList<Sach> listSach, DefaultTableModel model) {
        Object[] row = new Object[7];
        for (int i = 0; i < listSach.size(); i++) {
            row[0] = listSach.get(i).getMaSach();
            row[1] = listSach.get(i).getTenSach();
            row[2] = listSach.get(i).getTheLoai();
            row[3] = listSach.get(i).getTacGia();
            row[4] = listSach.get(i).getNhaXuatBan();
            row[5] = listSach.get(i).getNamXuatBan();
            row[6] = listSach.get(i).getGiaTien();
            model.addRow(row);
        }
    }

    public boolean addSach(String tenSach, String theLoai, String tacGia, String nhaXuatBan, int namXuatBan, int giaTien) {

        try {
            //Thêm một quyển sách vào trong cơ sở dữ liệu
            sqlCommand = "INSERT INTO quanlythuvien.sach(tensach, theloai, tacgia, nhaxuatban, namxuatban, giatien)  VALUES (?, ?, ?, ?, ?, ?)";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setString(1, tenSach);
            ps.setString(2, theLoai);
            ps.setString(3, tacGia);
            ps.setString(4, nhaXuatBan);
            ps.setInt(5, namXuatBan);
            ps.setInt(6, giaTien);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSach(int maSach, String tenSach, String theLoai, String tacGia, String nhaXuatBan, int namXuatBan, int giaTien) {
        try {
            sqlCommand = "UPDATE quanlythuvien.sach set tensach= '" + tenSach + "', theloai= '" + theLoai + "', tacgia= '" + tacGia + "', nhaxuatban= '" + nhaXuatBan + "', namxuatban = '" + namXuatBan + "', giatien = '" + giaTien + "' WHERE masach ='" + maSach + "'";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSach(int maSach) {
        try {
            sqlCommand = "DELETE FROM quanlythuvien.sach WHERE masach = ?";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setInt(1, maSach);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean searchSachFromCTMT(int maSach) {
        try {
            st = null;
            rs = null;
            sqlCommand = "select * from quanlythuvien.ctmuontra where masach = " + maSach;
            st = myConn.getConnection().createStatement();
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
            return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
    
