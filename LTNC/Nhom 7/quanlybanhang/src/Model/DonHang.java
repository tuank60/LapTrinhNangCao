/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ToanPC
 */
public class DonHang {
    private int KhachHang;
    private String TongTien;
    private Date NgayBan;
    private String BinhLuan;
    
    public DonHang(){
        
    }
    public DonHang(int KhachHang,String TongTien,Date NgayBan,String BinhLuan){
        
        this.KhachHang=KhachHang;
        this.TongTien=TongTien;
        this.NgayBan=NgayBan;
        this.BinhLuan=BinhLuan;
    }
    public int getKhachHang(){
        return KhachHang;
    }
    public void setKhachHang(int KhachHang){
        this.KhachHang=KhachHang;
    }
    public String getTongTien(){
        return TongTien;
    }
    public void setTongTien(String TongTien){
        this.TongTien=TongTien; 
    }
    public Date getNgayBan(){
        return NgayBan;
    }
    public void setNgayBan(Date NgayBan){
        this.NgayBan=NgayBan;
    }
    public String getBinhLuan(){
        return BinhLuan;
    }
    public void setBinhLuan(String BinhLuan){
        this.BinhLuan=BinhLuan;
    }
    
}
