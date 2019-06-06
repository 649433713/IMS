package IMS.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;
@Data
public class SaleForm {
    private String saleId;
    private String note;
    private String status;
    private String buyer;
    @NotEmpty(message = "时间必填")
    private LocalDateTime createTime;
    @NotEmpty(message = "进货商品不能为空")
    private String goodsList;

}
