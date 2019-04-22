package IMS.demo.converter;

import IMS.demo.dto.PurchaseDTO;
import IMS.demo.dto.PurchaseGoodsDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.SellException;
import IMS.demo.form.PurchaseForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class PurchaseForm2DTOConverter {
    public static PurchaseDTO convert(PurchaseForm purchaseForm) {
        PurchaseDTO purchaseDTO=new PurchaseDTO();
        purchaseDTO.setCreateTime(purchaseForm.getCreateTime());
        purchaseDTO.setNote(purchaseForm.getNote());
        purchaseDTO.setPurchaseId(purchaseForm.getPurchaseId());

        List<PurchaseGoodsDTO> purchaseGoodsDTOList;
        Gson gson = new Gson();
        try {
            purchaseGoodsDTOList = gson.fromJson(purchaseForm.getGoodsList(),new TypeToken<List<PurchaseGoodsDTO>>(){}.getType());

        }catch (Exception e){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        purchaseDTO.setGoodsList(purchaseGoodsDTOList);
        return  purchaseDTO;
    }
}
