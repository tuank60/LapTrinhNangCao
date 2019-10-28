/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class HangSP {
    private String TenHSP;
    private String SDT;
    private String Email;
    private String DiaChi;
    
    public HangSP(){
        
    }
    public HangSP(int IDHSP,String TenHSP,String SDT,String Email,String DiaChi){
        this.TenHSP=TenHSP;
        this.SDT=SDT;
        this.Email=Email;
        this.DiaChi=DiaChi;
    }
    public String getTenSP(){
        return TenHSP;
    }
    public void setTenSP(String TenSP){
        this.TenHSP=TenSP;
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
    public String getDiaChi(){
        return DiaChi;
    }
    public void setDiaChi(String DiaChi){
        this.DiaChi=DiaChi;
    }
    
}
