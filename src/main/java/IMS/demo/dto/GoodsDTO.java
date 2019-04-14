package IMS.demo.dto;

import IMS.demo.dataobject.ProductInfoPO;
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
    private String note;
    private double price;

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
    }

    public ProductInfoPO getPo() {
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
        return productInfoPO;
    }

}
