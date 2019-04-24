package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetailPO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleGoodsDTO {
    private String goodsId;
    private String name;
    private Integer num;
    private double price;
    private double priceSum;
    private String icon;

    public SaleGoodsDTO(OrderDetailPO orderDetailPO) {
        goodsId = orderDetailPO.getProductId();
        name = orderDetailPO.getProductName();
        num = orderDetailPO.getProductQuantity();
        price = orderDetailPO.getProductPrice().doubleValue();
        priceSum = num * priceSum;
        icon = orderDetailPO.getProductIcon();
    }

    public OrderDetailPO getPO() {
        OrderDetailPO orderDetailPO = new OrderDetailPO();
        orderDetailPO.setProductId(goodsId);
        orderDetailPO.setProductName(name);
        orderDetailPO.setProductQuantity(num);
        orderDetailPO.setProductPrice(new BigDecimal(price));
        orderDetailPO.setProductIcon(icon);

        return orderDetailPO;
    }
}
