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
}
