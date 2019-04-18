package IMS.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class BuyerForm {
    private String buyerId;
    @NotEmpty(message = "姓名必填")
    private String buyerName;
    private String contact;
    private String note;
    private String legalPerson;
    private String email;
    private String contactPerson;
    private String productionCategory;
}
