
package model;

import java.util.ArrayList;
import java.util.Date;

public class ChiTietMuonTra {
    
    private int maCTMT;
    private int maSach;
    private String tenSach;
    private String ngayMuon;
    private String hanTra;
    private String ngayTra;
    private int tienPhat;
    private String tinhTrang;
    private String ghiChu;

    
    public ChiTietMuonTra() {
    }

    public ChiTietMuonTra(int maCTMT, int maSach, String tenSach, String ngayMuon, String hanTra, String ngayTra, int tienPhat, String tinhTrang, String ghiChu) {
        this.maCTMT = maCTMT;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
        this.tienPhat = tienPhat;
        this.tinhTrang = tinhTrang;
        this.ghiChu = ghiChu;
    }

    public int getMaCTMT() {
        return maCTMT;
    }

    public void setMaCTMT(int maCTMT) {
        this.maCTMT = maCTMT;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getHanTra() {
        return hanTra;
    }

    public void setHanTra(String hanTra) {
        this.hanTra = hanTra;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   
}
