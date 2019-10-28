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
public class Product {
    private int Id, Price, Number;
    private String Detail, Name;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getNumber() {
        return Number;
    }

    public Product() {
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
