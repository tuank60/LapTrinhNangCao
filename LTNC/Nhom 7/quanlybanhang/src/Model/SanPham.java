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
public class SanPham {
    private String TenSP;
    private String MaSP;
    private int HangSP;
    private Date NSX;
    private String GiaTien;
    
    public SanPham(){
        
    }
    public SanPham(String TenSP,String MaSP,int HangSP,Date NSX,String GiaTien){
        this.TenSP=TenSP;
        this.MaSP=MaSP;
        this.HangSP=HangSP;
        this.NSX=NSX;
        this.GiaTien=GiaTien; 
    }

    public String getTenSP(){
        return TenSP;
    } 
    public void setTenSP(String TenSP){
        this.TenSP=TenSP;
    }
    public String getMaSP(){
        return MaSP;
    }
    public void setMaSP(String MaSP){
        this.MaSP=MaSP;
    }
    public int getHangSP(){
        return HangSP;
    }
    public void setHangSP(int HangSP){
        this.HangSP=HangSP;
    }
    public Date getNSX(){
        return NSX;
    }
    public void setNSX(Date NSX){
        this.NSX=NSX;
    }
    public String getGiaTien(){
        return GiaTien;
    }
    public void setGiaTien(String GiaTien){
        this.GiaTien=GiaTien;
    }   
}
