package IMS.demo.dto;

import IMS.demo.dataobject.CustomerPO;
import lombok.Data;

@Data
public class MemberDTO {
    private String memberId;
    private String memberName;
    private String tel;
    private String note;
    private double balance;

    public MemberDTO() {

    }

    public MemberDTO(CustomerPO customerPO) {
        memberId = customerPO.getCardNo();
        memberName = customerPO.getCustomerName();
        tel = customerPO.getContact();
        note = customerPO.getComments();
        balance= customerPO.getBalance();
    }

    public CustomerPO getPO() {
        CustomerPO customerPO = new CustomerPO();
        customerPO.setBalance(balance);
        customerPO.setCardNo(memberId);
        customerPO.setCustomerName(memberName);
        customerPO.setContact(tel);
        customerPO.setContact(note);
        return customerPO;
    }
}
