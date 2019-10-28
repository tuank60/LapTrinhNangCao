
package model;

import java.util.ArrayList;

public class ThongTinMuonTra {
    
    private int maMuonTra;
    private String tenDocGia;
    private int datCoc;
    private int soLuongChuaTra;
    private int tienPhat;
    private String ghiChu;
    private ArrayList<ChiTietMuonTra> listCTMT;

    public ThongTinMuonTra(){
        
    }
        
    public ThongTinMuonTra(int maMuonTra, String tenDocGia, int datCoc, int soLuongChuaTra, int tienPhat, String ghiChu, ArrayList<ChiTietMuonTra> listCTMT) {
        this.maMuonTra = maMuonTra;
        this.tenDocGia = tenDocGia;
        this.datCoc = datCoc;
        this.soLuongChuaTra = soLuongChuaTra;
        this.tienPhat = tienPhat;
        this.ghiChu = ghiChu;
        this.listCTMT = listCTMT;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public int getMaMuonTra() {
        return maMuonTra;
    }

    public void setMaMuonTra(int maMuonTra) {
        this.maMuonTra = maMuonTra;
    }

    public int getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(int datCoc) {
        this.datCoc = datCoc;
    }

    public int getSoLuongChuaTra() {
        return soLuongChuaTra;
    }

    public void setSoLuongChuaTra(int soLuongChuaTra) {
        this.soLuongChuaTra = soLuongChuaTra;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public ArrayList<ChiTietMuonTra> getListCTMT() {
        return listCTMT;
    }

    public void setListCTMT(ArrayList<ChiTietMuonTra> listCTMT) {
        this.listCTMT = listCTMT;
    }
    


    
}
