/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author DO ANH TUAN
 */
public class QuanLy {
    private String TenQL;
    private String TaiKhoan;
    private String MatKhau;
    private String GioiTinh;
    private Date NgaySinh;
    private String QueQuan;
    private String SDT;
    private String Email;
    
    public QuanLy(String TenQL, String TaiKhoan, String MatKhau, String GioiTinh, Date NgaySinh, String QueQuan, String SDT, String Email){
        this.TenQL=TenQL;
        this.TaiKhoan=TaiKhoan;
        this.MatKhau=MatKhau;
        this.GioiTinh=GioiTinh;
        this.NgaySinh=NgaySinh;
        this.QueQuan=QueQuan;
        this.SDT=SDT;
        this.Email=Email;
    }
    public String getTenQL(){
        return TenQL;
    }
    public void setTenQL(String TenQL){
        this.TenQL=TenQL;
    }
    
    public String getTaiKhoan(){
        return TaiKhoan;
    }
    public void setTaiKhoan(String TaiKhoan){
        this.TaiKhoan=TaiKhoan;
    }
    
    public String getMatKhau(){
        return MatKhau;
    }
    public void setMatKhau(String MatKhau){
        this.MatKhau=MatKhau;
    }
    
    public String getGioiTinh(){
        return GioiTinh;
    }
    public void setGioiTinh(String GioiTinh){
        this.GioiTinh=GioiTinh;
    }
    
    public Date getNgaySinh(){
        return NgaySinh;
    }
    public void setNgaySinh(Date NgaySinh){
        this.NgaySinh=NgaySinh;
    }
    
    public String getQueQuan(){
        return QueQuan;
    }
    public void setQueQuan(String QueQuan){
        this.QueQuan=QueQuan;
    }
    
    public String getSDT(){
        return SDT;
    }
    public void setSDT(String SDT){
        this.SDT=SDT;
    }
    
    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email=Email;
    }
}
