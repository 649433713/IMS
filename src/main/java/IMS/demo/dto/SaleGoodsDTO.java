package IMS.demo.dto;

import lombok.Data;

@Data
public class SaleGoodsDTO {
    private String goodsId;
    private String name;
    private Integer num;
    private double price;
    private double priceSum;
    private String note;
    private String icon;
}
