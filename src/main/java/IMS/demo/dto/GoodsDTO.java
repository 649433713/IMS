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
}
