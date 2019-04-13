package IMS.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class BuyerForm {
    private String buyerId;
    @NotEmpty(message = "姓名必填")
    private String buyerName;
    private String tel;
    private String note;

    public String getTel() {
        return tel;
    }

    public String getNote() {
        return note;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }
}
