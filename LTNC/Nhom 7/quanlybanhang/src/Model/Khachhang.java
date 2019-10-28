/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
public class Khachhang {
    private String MaKH;
    private String TenKH;
    private Date NgaySinh;
    private String SDT;
    private String QueQuan;
    private String Email;
    
    public Khachhang(){
    }
    public Khachhang(String MaKH,String TenKH,Date NgaySinh ,String SDT,String QueQuan ,String Email)
    {
        this.MaKH=MaKH;
        this.TenKH=TenKH;
        this.NgaySinh=NgaySinh;
        this.SDT=SDT;
        this.QueQuan=QueQuan;
        this.Email=Email; 
    }
    public String getMaKH(){
        return MaKH;
    }
    public void setMaKH(String MaKH){
        this.MaKH=MaKH;
    }
    public String getTenKH(){
        return TenKH;
    }
    public void setTenKH(String TenKH){
        this.TenKH=TenKH;
    }
    public Date getNgaySinh(){
        return NgaySinh;
    }
    public void setNgaySinh(Date NgaySinh){
        this.NgaySinh=NgaySinh;
    }
    public String getSDT(){
        return SDT;
    }
    public void setSDT(String SDT){
        this.SDT=SDT;
    }
    public String getQueQuan(){
        return QueQuan;
    }
    public void setQueQuan(String QueQuan){
        this.QueQuan=QueQuan;
    }
    public String getEmail(){
      return Email;
    }
    public void setEmail(String Email){
        this.Email=Email;
    }
}

