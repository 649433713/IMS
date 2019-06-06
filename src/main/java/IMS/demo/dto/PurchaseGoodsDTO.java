package IMS.demo.dto;

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

    public PurchaseGoodsDTO(StockPurchasePO stockPurchasePO) {
        goodsId = stockPurchasePO.getProductId();
        num = stockPurchasePO.getQuantity();
        price = stockPurchasePO.getUnitPrice();
        priceSum = stockPurchasePO.getAmount();
        tax = stockPurchasePO.getTax() > 0;
        buyer = stockPurchasePO.getSeller();
        note = stockPurchasePO.getComments();

        preservationMatters = stockPurchasePO.getPreservation();
        discount = stockPurchasePO.getDiscount();
    }

    public StockPurchasePO transferPO() {
        StockPurchasePO stockPurchasePO = new StockPurchasePO();
        stockPurchasePO.setAmount(priceSum);
        stockPurchasePO.setComments(note);
        stockPurchasePO.setProductId(goodsId);
        stockPurchasePO.setUnitPrice(price);
        stockPurchasePO.setQuantity(num);
        stockPurchasePO.setSeller(buyer);
        stockPurchasePO.setTax(tax?1.:0);
        stockPurchasePO.setPreservation(preservationMatters);
        stockPurchasePO.setDiscount(discount);

        return stockPurchasePO;
    }

    public PurchaseGoodsDTO() {

    }
}
