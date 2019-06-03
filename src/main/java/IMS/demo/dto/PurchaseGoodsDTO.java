package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetailPO;
import IMS.demo.dataobject.OrderMasterPO;
import IMS.demo.dataobject.StockPurchasePO;
import lombok.Data;

@Data
public class PurchaseGoodsDTO {
    private String goodsId;
    private Integer num;
    private double price;
    private double priceSum;

    private String buyer;
    private String note;

    private boolean tax;
    private String preservationMatters;//保存事项
    private double discount;//折扣

    public PurchaseGoodsDTO(OrderDetailPO orderDetailPO, OrderMasterPO orderMasterPO) {
        goodsId = orderDetailPO.getProductId();
        num = orderDetailPO.getProductQuantity();
        price = orderDetailPO.getProductPrice().doubleValue();
        priceSum = num * priceSum;
        tax = 0;
        buyer = orderMasterPO.getBuyerName() + " " + orderMasterPO.getBuyerContact();
        note = orderMasterPO.getOrderAbstract();
    }

    public PurchaseGoodsDTO(StockPurchasePO stockPurchasePO) {
        goodsId = stockPurchasePO.getProductId();
        num = stockPurchasePO.getQuantity();
        price = stockPurchasePO.getUnitPrice();
        priceSum = stockPurchasePO.getAmount();
        tax = stockPurchasePO.getTax();
        buyer = stockPurchasePO.getSeller();
        note = stockPurchasePO.getComments();
    }

    public StockPurchasePO transferPO() {
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

    public PurchaseGoodsDTO() {

    }
}
