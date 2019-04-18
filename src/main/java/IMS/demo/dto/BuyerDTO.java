package IMS.demo.dto;

import IMS.demo.dataobject.BuyerInfoPO;
import lombok.Data;

@Data
public class BuyerDTO {
    private String buyerId;
    private String buyerName;
    private String contact;
    private String note;
    private String productionCategory;
    private String legalPerson;
    private String email;
    private String contactPerson;

    public BuyerDTO(BuyerInfoPO buyerInfoPO) {
        buyerId = buyerInfoPO.getId();
        buyerName = buyerInfoPO.getName();
        contact = buyerInfoPO.getContact();
        note = buyerInfoPO.getComments();
        productionCategory=buyerInfoPO.getProductionCategory();
        legalPerson=buyerInfoPO.getLegalPerson();
        email=buyerInfoPO.getEmail();
        contactPerson=buyerInfoPO.getContactPerson();
    }

    public BuyerDTO() {

    }

    public BuyerInfoPO getPO() {
        BuyerInfoPO buyerInfoPO = new BuyerInfoPO();
        buyerInfoPO.setComments(note);
        buyerInfoPO.setContact(contact);
        buyerInfoPO.setId(buyerId);
        buyerInfoPO.setName(buyerName);
        buyerInfoPO.setContactPerson(contactPerson);
        buyerInfoPO.setEmail(email);
        buyerInfoPO.setProductionCategory(productionCategory);
        buyerInfoPO.setLegalPerson(legalPerson);

        return buyerInfoPO;
    }
}
