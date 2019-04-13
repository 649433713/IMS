package IMS.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberDTO {
    private String memberId;
    private String memberName;
    private String tel;
    private String note;
    private double price;

    public void setNote(String note) {
        this.note = note;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
