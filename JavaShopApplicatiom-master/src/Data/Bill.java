/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Duy.hv150601
 */
public class Bill {
    private int Id, TotalPrice,UserId, CustommerId, BillDetailId;

    public int getBillDetailId() {
        return BillDetailId;
    }

    public void setBillDetailId(int BillDetailId) {
        this.BillDetailId = BillDetailId;
    }
    private String Time;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getCustommerId() {
        return CustommerId;
    }

    public void setCustommerId(int CustommerId) {
        this.CustommerId = CustommerId;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public Bill() {
    }
}
