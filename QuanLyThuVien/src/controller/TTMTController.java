package controller;

import java.io.IOException;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.DocGia;
import model.MyConnect;
import model.Sach;
import model.ThongTinMuonTra;

public class TTMTController {

    private MyConnect myConn;
    private ThongTinMuonTra ttmt;
    private ArrayList<ThongTinMuonTra> listTTMT;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlCommand;
    private String sqlCommand1;
    private String sqlCommand2;
    private String sqlCommand3;

    public TTMTController() {
        myConn = new MyConnect();
    }

    public ArrayList<ThongTinMuonTra> getListTTMT(int maMuonTra, String tenDocGia) throws IOException, SQLException {
        listTTMT = new ArrayList<ThongTinMuonTra>();
        st = null;
        rs = null;
        sqlCommand1 = "SELECT * FROM  quanlythuvien.dg_ttmt_view";
        sqlCommand2 = "SELECT * FROM quanlythuvien.dg_ttmt_view WHERE mamuontra = " + maMuonTra;
        sqlCommand3 = "SELECT * FROM quanlythuvien.dg_ttmt_view WHERE tenDocGia = '" + tenDocGia + "'";
        try {
            st = myConn.getConnection().createStatement();
            if (maMuonTra != 0) {
                sqlCommand = sqlCommand2;
            } else if (tenDocGia != "") {
                sqlCommand = sqlCommand3;
            } else {
                sqlCommand = sqlCommand1;
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                ttmt = new ThongTinMuonTra(rs.getInt("mamuontra"), rs.getString("tendocgia"), rs.getInt("datcoc"), rs.getInt("soluongchuatra"), rs.getInt("tienphat"), rs.getString("ghichu") + "", null);
                listTTMT.add(ttmt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myConn.getConnection().close();
        }

        return listTTMT;
    }

    public void show_TTMT_On_JTable(ArrayList<ThongTinMuonTra> listTTMT, DefaultTableModel model) {
        Object[] row = new Object[6];
        for (int i = 0; i < listTTMT.size(); i++) {
            row[0] = listTTMT.get(i).getMaMuonTra();
            row[1] = listTTMT.get(i).getTenDocGia();
            row[2] = listTTMT.get(i).getDatCoc();
            row[3] = listTTMT.get(i).getSoLuongChuaTra();
            row[4] = listTTMT.get(i).getTienPhat();
            row[5] = listTTMT.get(i).getGhiChu() + "";
            model.addRow(row);
        }
    }

    // Hàm lấy danh sách mã độc giả chưa xuất hiện trong bảng thông tin mượn trả để thêm vào combobox
    public ArrayList<Integer> getListMaTTMTForCombobox(ArrayList<DocGia> listDocGia, ArrayList<ThongTinMuonTra> listttmt) {
        ArrayList<Integer> listInteger = new ArrayList<Integer>();

        // Xét lần lượt từng độc giả một
        for (DocGia dg : listDocGia) {
            // Ban đầu không tìm thấy độc giả, biến timThay = false
            boolean timThay = false;
            // Duyệt danh sách thông tin mượn trả, tìm xem có TTMT nào trùng mã độc giả hay không ?
            for (ThongTinMuonTra ttmt : listTTMT) {
                if (dg.getMaDocGia() == ttmt.getMaMuonTra()) {
                    // Nếu tìm thấy thì biến timThay = true, thoát ra vòng lặp gần nhất, ko cần tìm kiếm thêm
                    // và xét độc giả tiếp theo
                    timThay = true;
                    break;
                }
            }
            // Sau khi ra khỏi vòng For tức là duyệt hết danh sách TTMT, nếu biến timThay vẫn = false
            // nghĩa là chưa tồn tại độc giả đó trong danh sách TTMT => thêm vào hàng chờ Combobox
            if (timThay == false) {
                listInteger.add(dg.getMaDocGia());
            }
        }
        return listInteger;
    }

    // Hàm lấy danh sách tên độc giả chưa xuất hiện trong bảng thông tin mượn để thêm vào combobox
    public ArrayList<String> getListNameForCombobox(ArrayList<DocGia> listDocGia, ArrayList<ThongTinMuonTra> listttmt) {
        ArrayList<String> listName = new ArrayList<String>();
        // Xét lần lượt từng độc giả một
        for (DocGia dg : listDocGia) {
            // Ban đầu không tìm thấy độc giả, biến timThay = false
            boolean timThay = false;
            // Duyệt danh sách thông tin mượn trả, tìm xem có TTMT nào trùng mã độc giả hay không ?
            for (ThongTinMuonTra ttmt : listTTMT) {
                if (dg.getMaDocGia() == ttmt.getMaMuonTra()) {
                    // Nếu tìm thấy thì biến timThay = true, thoát ra vòng lặp gần nhất, ko cần tìm kiếm thêm
                    // và xét độc giả tiếp theo
                    timThay = true;
                    break;
                }
            }
            // Sau khi ra khỏi vòng For tức là duyệt hết danh sách TTMT, nếu biến timThay vẫn = false
            // nghĩa là chưa tồn tại độc giả đó trong danh sách TTMT => thêm vào hàng chờ Combobox
            if (timThay == false) {
                listName.add(dg.getTenDocGia());
            }
        }
        return listName;
    }

    public boolean addTTMT(int maMuonTra) throws IOException, SQLException {
        try {
            sqlCommand = "INSERT INTO quanlythuvien.ttmuontra (mamuontra, datcoc, soluongchuatra, tienphat, ghichu) VALUES (?, ?, ?, ?, ?)   ";
            ps = myConn.getConnection().prepareStatement(sqlCommand);
            ps.setInt(1, maMuonTra);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setString(5, "");
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

    public boolean updateTTMT(int maMuonTra, int datCoc, int soLuongChuaTra, int tienPhat, String ghiChu) throws IOException, SQLException {
        try {
            sqlCommand = "UPDATE quanlythuvien.ttmuontra set mamuontra= '" + maMuonTra + "', datcoc = '" + datCoc + "', soluongchuatra= '" + soLuongChuaTra + "', tienphat= '" + tienPhat + "', ghichu = '" + ghiChu + "' WHERE mamuontra ='" + maMuonTra + "'";
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

    public boolean deleteTTMT(int maMuonTra) throws IOException, SQLException {
        try {
            sqlCommand = "DELETE FROM quanlythuvien.ttmuontra WHERE mamuontra = " + maMuonTra;
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

    // Hàm cập nhật tiền đặt cọc và số lượng chi tiết mượn chưa trả sau khi bấm thêm 1 thông tin mượn mới
    public void update_TTMT_After_Add_New_CTMT(int maTTMT, int maSach) throws IOException, SQLException {
        // Lấy về số tiền đặt cọc cũ và số lượng chưa trả cũ
        int datCocCu = 0;
        int chuaTraCu = 0;
        st = null;
        rs = null;
        sqlCommand1 = "SELECT * FROM  quanlythuvien.ttmuontra WHERE mamuontra = " + maTTMT;
        st = myConn.getConnection().createStatement();
        rs = st.executeQuery(sqlCommand1);
        while (rs.next()) {
            ttmt = new ThongTinMuonTra(rs.getInt("mamuontra"), "", rs.getInt("datcoc"), rs.getInt("soluongchuatra"), rs.getInt("tienphat"), rs.getString("ghichu") + "", null);
        }
        datCocCu = ttmt.getDatCoc();
        chuaTraCu = ttmt.getSoLuongChuaTra();

        // Lấy về giá tiền quyển sách mới thêm
        int giaSachMoiThem = 0;
        Statement st2;
        ResultSet rs2;
        Sach sach = null;
        sqlCommand2 = "select * from sach where masach = " + maSach;
        st2 = myConn.getConnection().createStatement();
        rs2 = st2.executeQuery(sqlCommand2);
        while (rs2.next()) {
            sach = new Sach(rs2.getInt("masach"), rs2.getString("tensach"), rs2.getString("theloai"), rs2.getString("tacgia"), rs2.getString("nhaxuatban"), rs2.getInt("namxuatban"), rs2.getInt("giatien"));
        }
        giaSachMoiThem = sach.getGiaTien();
        // Cập nhật lại số tiền đặt cọc mới += 25% tiền quyển sách và tăng số lượng chưa trả thêm 1 
        float datCocMoi = (float) (datCocCu + (25 * giaSachMoiThem) / 100.0);
        int soLuongChuaTraMoi = chuaTraCu + 1;
        sqlCommand3 = "UPDATE quanlythuvien.ttmuontra set datcoc = '" + datCocMoi + "', soluongchuatra= '" + soLuongChuaTraMoi + "' WHERE mamuontra ='" + maTTMT + "'";
        ps = myConn.getConnection().prepareStatement(sqlCommand3);
        ps.executeUpdate();
        ps.close();
        myConn.getConnection().close();
    }

    /**
     * Hàm cập nhật lại thông tin mượn trả sau khi trả sách bao gồm cập nhật lại
     * tiền đặt cọc, số lượng chưa trả, tiền phạt
     */
    public void update_TTMT_After_TraSach(int maTTMT, int maSach, int tienPhat) throws IOException, SQLException {
        // Lấy về số tiền đặt cọc cũ, số lượng chưa trả cũ, tiền phạt cũ
        int datCocCu = 0;
        int chuaTraCu = 0;
        int tienPhatCu = 0;
        st = null;
        rs = null;
        sqlCommand1 = "SELECT * FROM  quanlythuvien.ttmuontra WHERE mamuontra = " + maTTMT;
        st = myConn.getConnection().createStatement();
        rs = st.executeQuery(sqlCommand1);
        while (rs.next()) {
            ttmt = new ThongTinMuonTra(rs.getInt("mamuontra"), "", rs.getInt("datcoc"), rs.getInt("soluongchuatra"), rs.getInt("tienphat"), rs.getString("ghichu") + "", null);
        }
        datCocCu = ttmt.getDatCoc();
        chuaTraCu = ttmt.getSoLuongChuaTra();
        tienPhatCu = ttmt.getTienPhat();

        // Lấy về giá tiền quyển sách muốn trả
        int giaSachMuonTra = 0;
        Statement st2;
        ResultSet rs2;
        Sach sach = null;
        sqlCommand2 = "select * from sach where masach = " + maSach;
        st2 = myConn.getConnection().createStatement();
        rs2 = st2.executeQuery(sqlCommand2);
        while (rs2.next()) {
            sach = new Sach(rs2.getInt("masach"), rs2.getString("tensach"), rs2.getString("theloai"), rs2.getString("tacgia"), rs2.getString("nhaxuatban"), rs2.getInt("namxuatban"), rs2.getInt("giatien"));
        }
        giaSachMuonTra = sach.getGiaTien();

        /** Cập nhật lại số tiền đặt cọc mới -= 25% tiền quyển sách và giảm số lượng chưa trả đi 1 
        *   tiền phạt mới = tiền phạt cũ + tiền phạt ( lấy về trên giao diện)
        */
        float datCocMoi = (float) (datCocCu - (25 * giaSachMuonTra) / 100.0);
        int soLuongChuaTraMoi = chuaTraCu - 1;
        int tienPhatMoi = tienPhatCu + tienPhat;
        sqlCommand3 = "UPDATE quanlythuvien.ttmuontra set datcoc = '" + datCocMoi + "', soluongchuatra= '" + soLuongChuaTraMoi + "', tienphat = '" + tienPhatMoi + "' WHERE mamuontra ='" + maTTMT + "'";
        ps = myConn.getConnection().prepareStatement(sqlCommand3);
        ps.executeUpdate();
        ps.close();
        myConn.getConnection().close();
    }
}
