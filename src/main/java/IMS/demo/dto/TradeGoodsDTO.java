package IMS.demo.dto;

import lombok.Data;

@Data
public class TradeGoodsDTO {
    private String goodsId;
    private Integer num;
    private double price;
    private double priceSum;
    private double tax;
    private String buyer;
    private String note;
}
