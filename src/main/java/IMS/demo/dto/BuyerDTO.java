package IMS.demo.dto;

import lombok.Data;

@Data
public class BuyerDTO {
    private String buyerId;
    private String buyerName;
    private String tel;
    private String note;

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
