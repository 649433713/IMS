package IMS.demo.converter;

import IMS.demo.dto.BuyerDTO;
import IMS.demo.form.BuyerForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuyerForm2DTOConverter {
    public static BuyerDTO convert(BuyerForm buyForm) {
        BuyerDTO buyerDTO=new BuyerDTO();
        buyerDTO.setBuyerId(buyForm.getBuyerId());
        buyerDTO.setBuyerName(buyForm.getBuyerName());
        buyerDTO.setNote(buyForm.getNote());
        buyerDTO.setTel(buyForm.getTel());
        return buyerDTO;

    }
}
