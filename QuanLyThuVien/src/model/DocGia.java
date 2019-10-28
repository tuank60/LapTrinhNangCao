
package model;

import java.util.Date;

public class DocGia {
    private int maDocGia;
    private String tenDocGia;
    private String ngaySinh;
    private String lop;
    private int soDienThoai;
    private String queQuan;
    
    public DocGia(){
        
    }

    public DocGia(int maDocGia, String tenDocGia, String ngaySinh, String lop, int soDienThoai, String queQuan) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.soDienThoai = soDienThoai;
        this.queQuan = queQuan;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    
    
    
}
