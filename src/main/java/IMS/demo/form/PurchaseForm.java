package IMS.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;

@Data
public class PurchaseForm {
    private String purchaseId;
    private String note;
    @NotEmpty(message = "时间必填")
    private LocalDateTime createTime;
    @NotEmpty(message = "进货商品不能为空")
    private String goodsList;

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

}
