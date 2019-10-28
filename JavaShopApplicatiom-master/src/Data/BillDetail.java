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
public class BillDetail {
    private int Id, Number, Price, ProductId;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public BillDetail() {
    }
    
}
