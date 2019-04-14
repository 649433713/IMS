package IMS.demo.dto;

import IMS.demo.dataobject.BuyerInfoPO;
import lombok.Data;

@Data
public class BuyerDTO {
    private String buyerId;
    private String buyerName;
    private String tel;
    private String note;

    public BuyerDTO(BuyerInfoPO buyerInfoPO) {
        buyerId = buyerInfoPO.getId();
        buyerName = buyerInfoPO.getName();
        tel = buyerInfoPO.getContact();
        note = buyerInfoPO.getComments();
    }

    public BuyerInfoPO getPO() {
        BuyerInfoPO buyerInfoPO = new BuyerInfoPO();
        buyerInfoPO.setComments(note);
        buyerInfoPO.setContact(tel);
        buyerInfoPO.setId(buyerId);
        buyerInfoPO.setName(buyerName);
        return buyerInfoPO;
    }
}
