package IMS.demo.dto;

import lombok.Data;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
@Data
public class CartDTO {

    private String productId;

    private  Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
