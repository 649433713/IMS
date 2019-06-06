package IMS.demo.dto;

import IMS.demo.dataobject.BuyerInfoPO;
import IMS.demo.enums.GenderEnum;
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

    private String buyCategory;//采购类别
    private String sex;//性别
    private String career;//性别

    public BuyerDTO(BuyerInfoPO buyerInfoPO) {
        buyerId = buyerInfoPO.getId();
        buyerName = buyerInfoPO.getName();
        contact = buyerInfoPO.getContact();
        note = buyerInfoPO.getComments();
        productionCategory=buyerInfoPO.getProductionCategory();
        legalPerson=buyerInfoPO.getLegalPerson();
        email=buyerInfoPO.getEmail();
        contactPerson=buyerInfoPO.getContactPerson();
        buyCategory = buyerInfoPO.getPurchaseCategory();
        sex = GenderEnum.valueOf(buyerInfoPO.getGender());
        career = buyerInfoPO.getDuty();
    }

    public BuyerDTO() {

    }

    public BuyerInfoPO transferPO() {
        BuyerInfoPO buyerInfoPO = new BuyerInfoPO();
        buyerInfoPO.setComments(note);
        buyerInfoPO.setContact(contact);
        buyerInfoPO.setId(buyerId);
        buyerInfoPO.setName(buyerName);
        buyerInfoPO.setContactPerson(contactPerson);
        buyerInfoPO.setEmail(email);
        buyerInfoPO.setProductionCategory(productionCategory);
        buyerInfoPO.setLegalPerson(legalPerson);
        buyerInfoPO.setGender(GenderEnum.valueOf(sex).getCode().byteValue());
        buyerInfoPO.setDuty(career);

        return buyerInfoPO;
    }
}
