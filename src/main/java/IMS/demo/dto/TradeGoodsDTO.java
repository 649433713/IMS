package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetailPO;
import IMS.demo.dataobject.OrderMasterPO;
import IMS.demo.dataobject.StockPurchasePO;
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

    public TradeGoodsDTO(StockPurchasePO stockPurchasePO) {
        goodsId = stockPurchasePO.getProductId();
        num = stockPurchasePO.getQuantity();
        price = stockPurchasePO.getUnitPrice();
        priceSum = stockPurchasePO.getAmount();
        tax = stockPurchasePO.getTax();
        buyer = stockPurchasePO.getSeller();
        note = stockPurchasePO.getComments();
    }

    public StockPurchasePO getPO() {
        StockPurchasePO stockPurchasePO = new StockPurchasePO();
        stockPurchasePO.setAmount(priceSum);
        stockPurchasePO.setComments(note);
        stockPurchasePO.setProductId(goodsId);
        stockPurchasePO.setUnitPrice(price);
        stockPurchasePO.setQuantity(num);
        stockPurchasePO.setSeller(buyer);
        stockPurchasePO.setTax(tax);
        return stockPurchasePO;
    }

    public TradeGoodsDTO() {

    }
}
