package IMS.demo.form;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberForm {
    private String memberId;
    @NotEmpty(message = "姓名必填")
    private String memberName;
    private String tel;
    private String note;
    private double price;

    public double getPrice() {
        return price;
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
