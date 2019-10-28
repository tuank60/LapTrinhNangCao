package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.DocGia;
import model.MyConnect;
import model.Sach;

public class DocGiaController {

    private MyConnect myConn;
    private ArrayList<DocGia> listDocGia;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String sqlCommand;
    private String sqlCommand1;
    private String sqlCommand2;
    private String sqlCommand3;
    private DocGia docGia;

    public DocGiaController() {
        myConn = new MyConnect();
    }

    public ArrayList<DocGia> getListDocGia(int maDocGia, String tenDocGia) throws SQLException, IOException {
        listDocGia = new ArrayList<DocGia>();
        st = null;
        rs = null;
        sqlCommand1 = "select * from docgia";
        sqlCommand2 = "select * from docgia where madocgia = " + maDocGia;
        sqlCommand3 = "select * from docgia where tendocgia = '" + tenDocGia + "'";

        try {
            st = myConn.getConnection().createStatement();
            if (maDocGia != 0) {
                sqlCommand = sqlCommand2;
            } else if (tenDocGia != "") {
                sqlCommand = sqlCommand3;
            } else {
                sqlCommand = sqlCommand1;
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                docGia = new DocGia(rs.getInt("madocgia"), rs.getString("tendocgia"), rs.getDate("ngaysinh") + "", rs.getString("lop"), rs.getInt("dienthoai"), rs.getString("quequan"));
                listDocGia.add(docGia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }

        return listDocGia;
    }

    public void show_DocGia_On_JTable(ArrayList<DocGia> listDocGia, DefaultTableModel model) {
        Object[] row = new Object[6];
        for (int i = 0; i < listDocGia.size(); i++) {
            row[0] = listDocGia.get(i).getMaDocGia();
            row[1] = listDocGia.get(i).getTenDocGia();
            row[2] = listDocGia.get(i).getNgaySinh();
            row[3] = listDocGia.get(i).getLop();
            row[4] = listDocGia.get(i).getSoDienThoai();
            row[5] = listDocGia.get(i).getQueQuan();
            model.addRow(row);
        }
    }

    public boolean addDocGia(int maDocGia, String tenDocGia, String ngaySinh, String lop, int dienThoai, String queQuan) {
        try {
            String sqlCommand = "INSERT INTO quanlythuvien.docgia(madocgia, tendocgia, ngaysinh, lop, dienthoai, quequan)  VALUES (?, ?, ?, ?, ?, ?)";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setInt(1, maDocGia);
            ps.setString(2, tenDocGia);
            ps.setString(3, ngaySinh);
            ps.setString(4, lop);
            ps.setInt(5, dienThoai);
            ps.setString(6, queQuan);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDocGia(int maDocGia, String tenDocGia, String ngaySinh, String lop, int dienThoai, String queQuan) {
        try {
            String sqlCommand = "UPDATE quanlythuvien.docgia set tendocgia= '" + tenDocGia + "', ngaysinh= '" + ngaySinh + "', lop= '" + lop + "', dienthoai= '" + dienThoai + "', quequan = '" + queQuan + "' WHERE madocgia ='" + maDocGia + "'";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDocGia(int maDocGia) {
        try {
            sqlCommand = "DELETE FROM quanlythuvien.docgia WHERE madocgia = ?";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setInt(1, maDocGia);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Hàm kiểm tra xem đã tồn tại trong CSDL độc giả có mã điền vào hay không ? ( khi thêm mới độc giả )
    public boolean isExistedDG(int maDocGia) {
        st = null;
        rs = null;
        sqlCommand = "select * from docgia where madocgia = '" + maDocGia + "'";
        try {
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
    // Hàm kiểm tra có cho xóa độc giả hay không, Trả về False là không cho phép xóa khi số lượng chưa trả của độc giả trong bảng 
    // thông tin mượn lớn hơn 0
    public boolean  checkToDeleteDocGia(int maDocGia){
        try {
            st = null;
            rs = null;
            sqlCommand = "select * from quanlythuvien.ttmuontra where mamuontra = '" + maDocGia+ "'AND soluongchuatra > 0 ";
            st = myConn.getConnection().createStatement();
            rs = st.executeQuery(sqlCommand);           
            while (rs.next()) {
                docGia = new DocGia(rs.getInt("madocgia"), rs.getString("tendocgia"), rs.getDate("ngaysinh") + "", rs.getString("lop"), rs.getInt("dienthoai"), rs.getString("quequan"));
                if (docGia != null) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
