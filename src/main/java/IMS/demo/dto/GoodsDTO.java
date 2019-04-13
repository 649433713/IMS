package IMS.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDTO {
    private String goodsId;
    private String name;
    private String category;
    private String brand;
    private String size;
    private String danwei;
    private double weight;
    private String note ;
    private double price;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getDanwei() {
        return danwei;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public String getNote() {
        return note;
    }

    public String getSize() {
        return size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
