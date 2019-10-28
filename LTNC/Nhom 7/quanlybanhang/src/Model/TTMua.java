/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ToanPC
 */
public class TTMua {
    private int IDDonHang;
    private int IDSanPham;
    private int SoLuong;
    
    public TTMua(){
        
    }
    public TTMua(int IDM,int IDDonHang,int IDSanPham,int SoLuong){
        this.IDDonHang=IDDonHang;
        this.IDSanPham=IDSanPham;
        this.SoLuong=SoLuong;
        
    }
    public int getIDDonHang(){
        return IDDonHang;
    }
    public void setIDDonHang(int IDDonHang){
        this.IDDonHang=IDDonHang;
    }
    public int getIDSanPham(){
        return IDSanPham;
    }
    public void setIDSanPham(int IDSanPham){
        this.IDSanPham=IDSanPham;
    }
    public int getSoLuong(){
        return SoLuong;
    }
    public void setSoLuong(int SoLuong){
        this.SoLuong=SoLuong;
    }
    
}
