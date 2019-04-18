package IMS.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
@Data
public class MemberForm {
    private String memberId;
    @NotEmpty(message = "姓名必填")
    private String memberName;
    private String tel;
    private String note;
    private double balance;
    private String email;

    public double getBalance() {
        return balance;
    }

    public String getNote() {
        return note;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTel() {
        return tel;
    }
}
