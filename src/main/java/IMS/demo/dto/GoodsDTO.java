package IMS.demo.dto;

import IMS.demo.dataobject.ProductInfoPO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDTO {
    private String goodsId;
    private String name;

    private String category;//种类
    private String brand;//品牌
    private String size;//规格
    private String danwei;//单位
    private double weight;//重量
    private String note;
    private double price;
    private String placeOfOrigin;//产地
    private Integer bestBeforeDate;

    private String shortName;//简名
    private String color;
    private String articleNumber;//货号
    private String material;//材料
    private String model;//型号



    public GoodsDTO(ProductInfoPO productInfoPO) {

        goodsId = productInfoPO.getProductId();
        name = productInfoPO.getProductName();
        category = productInfoPO.getProductModel();
        brand = productInfoPO.getProductBrand();
        size = productInfoPO.getProductSize();
        danwei = productInfoPO.getProductUnit();
        weight = productInfoPO.getProductWeight()/1000.0;
        note = productInfoPO.getProductDescription();
        price = productInfoPO.getProductPrice().doubleValue();
        placeOfOrigin=productInfoPO.getPlaceOfOrigin();
        bestBeforeDate=productInfoPO.getBestBeforeDate();
    }

    public GoodsDTO() {

    }

    public ProductInfoPO transferPO() {
        ProductInfoPO productInfoPO = new ProductInfoPO();
        productInfoPO.setProductModel(category);
        productInfoPO.setProductId(goodsId);
        productInfoPO.setProductName(name);
        productInfoPO.setProductBrand(brand);
        productInfoPO.setProductSize(size);
        productInfoPO.setProductUnit(danwei);
        productInfoPO.setProductWeight((int)weight*1000);
        productInfoPO.setProductDescription(note);
        productInfoPO.setProductPrice(new BigDecimal(price));
        productInfoPO.setPlaceOfOrigin(placeOfOrigin);
        productInfoPO.setBestBeforeDate(bestBeforeDate);
        return productInfoPO;
    }

}
