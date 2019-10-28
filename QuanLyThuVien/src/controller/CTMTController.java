package controller;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.ChiTietMuonTra;
import model.DocGia;
import model.MyConnect;
import model.Sach;
import model.ThongTinMuonTra;

public class CTMTController {

    private MyConnect myConn;
    private ArrayList<ChiTietMuonTra> listCTMT;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String sqlCommand, sqlCommand1, sqlCommand2;
//    private String sqlCommand1;
//    private String sqlCommand2;
//    private String sqlCommand3;

    private ChiTietMuonTra ctmt;

    public CTMTController() {
        myConn = new MyConnect();
    }

    public ArrayList<ChiTietMuonTra> getListCTMT(int maMuonTra) throws SQLException, IOException {
        listCTMT = new ArrayList<ChiTietMuonTra>();
        st = null;
        rs = null;
        sqlCommand1 = "select * from quanlythuvien.dg_sach_ctmt_view WHERE mactmt =" + maMuonTra;
        sqlCommand2 = "select * from quanlythuvien.dg_sach_ctmt_view ";
        try {
            st = myConn.getConnection().createStatement();
            if (maMuonTra != 0) {
                sqlCommand = sqlCommand1;
            } else {
                sqlCommand = sqlCommand2;
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                ctmt = new ChiTietMuonTra(rs.getInt("mactmt"), rs.getInt("masach"), rs.getString("tensach"), rs.getString("ngaymuon"), rs.getString("hantra"), rs.getString("ngaytra"), rs.getInt("tienphat"), rs.getString("tinhtrang"), rs.getString("ghichu"));
                listCTMT.add(ctmt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }
        return listCTMT;
    }

    public void show_CTMT_On_JTable(ArrayList<ChiTietMuonTra> listCTMT, DefaultTableModel model) {
        Object[] row = new Object[9];
        for (int i = 0; i < listCTMT.size(); i++) {
            row[0] = listCTMT.get(i).getMaCTMT();
            row[1] = listCTMT.get(i).getMaSach();
            row[2] = listCTMT.get(i).getTenSach();
            row[3] = listCTMT.get(i).getNgayMuon();
            row[4] = listCTMT.get(i).getHanTra();
            row[5] = listCTMT.get(i).getNgayTra();
            row[6] = listCTMT.get(i).getTienPhat();
            row[7] = listCTMT.get(i).getTinhTrang();
            row[8] = listCTMT.get(i).getGhiChu();
            model.addRow(row);
        }
    }

    public boolean getMaSachFromChiTietMuonTra(int mactmt) {
        st = null;
        rs = null;
        try {

            sqlCommand = "SELECT masach FROM quanlythuvien.ctmuontra WHERE mactmt = " + mactmt;
            st = myConn.getConnection().createStatement();
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                //listMaSach.add(rs.getInt("masach"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Integer> getListMaSachForCombobox(ArrayList<Sach> listSach, ArrayList<ChiTietMuonTra> listCTMT) {
        ArrayList<Integer> listInteger = new ArrayList<Integer>();

        // Xét lần lượt từng quyển sách một
        for (Sach sach : listSach) {
            // Ban đầu không tìm thấy độc giả, biến timThay = false
            boolean timThay = false;
            // Duyệt danh sách thông tin mượn trả, tìm xem có TTMT nào trùng mã độc giả hay không ?
            for (ChiTietMuonTra ctmt : listCTMT) {
                if (sach.getMaSach() == ctmt.getMaSach()) {
                    // Nếu tìm thấy thì biến timThay = true, thoát ra vòng lặp gần nhất, ko cần tìm kiếm thêm
                    // và xét độc giả tiếp theo
                    timThay = true;
                    break;
                }
            }
            // Sau khi ra khỏi vòng For tức là duyệt hết danh sách TTMT, nếu biến timThay vẫn = false
            // nghĩa là chưa tồn tại độc giả đó trong danh sách TTMT => thêm vào hàng chờ Combobox
            if (timThay == false) {
                listInteger.add(sach.getMaSach());
            }
        }
        return listInteger;
    }

    public ArrayList<String> getListTenSachForCombobox(ArrayList<Sach> listSach, ArrayList<ChiTietMuonTra> listCTMT) {
        ArrayList<String> listName = new ArrayList<String>();
        for (Sach sach : listSach) {
            // Ban đầu không tìm thấy độc giả, biến timThay = false
            boolean timThay = false;
            // Duyệt danh sách thông tin mượn trả, tìm xem có TTMT nào trùng mã độc giả hay không ?
            for (ChiTietMuonTra ctmt : listCTMT) {
                if (sach.getMaSach() == ctmt.getMaSach()) {
                    // Nếu tìm thấy thì biến timThay = true, thoát ra vòng lặp gần nhất, ko cần tìm kiếm thêm
                    // và xét độc giả tiếp theo
                    timThay = true;
                    break;
                }
            }
            // Sau khi ra khỏi vòng For tức là duyệt hết danh sách TTMT, nếu biến timThay vẫn = false
            // nghĩa là chưa tồn tại độc giả đó trong danh sách TTMT => thêm vào hàng chờ Combobox
            if (timThay == false) {
                listName.add(sach.getTenSach());
            }
        }
        return listName;
    }

    public boolean addCTMT(int maCTMT, int maSach, String ngayMuon, String hanTra, String ngayTra, int tienPhat, String tinhTrang, String ghiChu) throws IOException, SQLException {
        try {
            sqlCommand = "INSERT INTO quanlythuvien.ctmuontra (mactmt, masach, ngaymuon, hantra, ngaytra, tienphat, tinhtrang, ghichu) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setInt(1, maCTMT);
            ps.setInt(2, maSach);
            ps.setString(3, ngayMuon);
            ps.setString(4, hanTra);
            ps.setString(5, ngayTra);
            ps.setInt(6, tienPhat);
            ps.setString(7, tinhTrang);
            ps.setString(8, ghiChu);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }
        return false;
    }

    public boolean updateCTMT(int maCTMT, int maSach, String ngayMuon, String hanTra, String ngayTra, int tienPhat, String tinhTrang, String ghiChu) throws IOException, SQLException {
        try {
            if (ngayTra.equalsIgnoreCase("")) {
                // Trường hợp ngày trả để trống thì đặt ngaytra = null vào cơ sở dữ liệu
                sqlCommand = "UPDATE quanlythuvien.ctmuontra set ngaymuon= '" + ngayMuon + "', hantra = '" + hanTra + "', ngayTra = " + null + ", tienphat= '" + tienPhat + "', tinhtrang= '" + tinhTrang + "', ghichu = '" + ghiChu + "' WHERE mactmt ='" + maCTMT + "' AND masach = '" + maSach + "'";
            } else {
                // Trường hợp ngày trả là 1 ngày nào đó thì đặt ngày trả bằng chính ngày đó
                sqlCommand = "UPDATE quanlythuvien.ctmuontra set ngaymuon= '" + ngayMuon + "', hantra = '" + hanTra + "', ngayTra = '" + ngayTra + "', tienphat= '" + tienPhat + "', tinhtrang= '" + tinhTrang + "', ghichu = '" + ghiChu + "' WHERE mactmt ='" + maCTMT + "' AND masach = '" + maSach + "'";
            }
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }
        return false;
    }

    public boolean deleteCTMT(int maCTMT, int maSach) throws IOException, SQLException {
        try {
            sqlCommand = "DELETE FROM quanlythuvien.ctmuontra WHERE mactmt = " + maCTMT + " AND masach =" + maSach;
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }
        return false;
    }
}
