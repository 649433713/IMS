package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetailPO;
import IMS.demo.dataobject.OrderMasterPO;
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

    public TradeGoodsDTO(OrderDetailPO orderDetailPO, OrderMasterPO orderMasterPO) {
        goodsId = orderDetailPO.getProductId();
        num = orderDetailPO.getProductQuantity();
        price = orderDetailPO.getProductPrice().doubleValue();
        priceSum = num * priceSum;
        tax = 0;
        buyer = orderMasterPO.getBuyerName() + " " + orderMasterPO.getBuyerContact();
        note = orderMasterPO.getOrderAbstract();
    }

    public TradeGoodsDTO(PurchaseDTO purchaseDTO) {

    }
}
