package IMS.demo.form;

import IMS.demo.dto.TradeGoodsDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseForm {
    private String purchaseId;
    private String note;
    @NotEmpty(message = "时间必填")
    private LocalDateTime createTime;

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
