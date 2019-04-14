package IMS.demo.converter;

import IMS.demo.dto.PurchaseDTO;
import IMS.demo.dto.TradeGoodsDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.SellException;
import IMS.demo.form.PurchaseForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class PurchaseForm2DTOConverter {
    public static PurchaseDTO convert(PurchaseForm purchaseForm) {
        PurchaseDTO purchaseDTO=new PurchaseDTO();
        purchaseDTO.setCreateTime(purchaseForm.getCreateTime());
        purchaseDTO.setNote(purchaseForm.getNote());
        purchaseDTO.setPurchaseId(purchaseForm.getPurchaseId());

        List<TradeGoodsDTO> tradeGoodsDTOList;
        Gson gson = new Gson();
        try {
            tradeGoodsDTOList = gson.fromJson(purchaseForm.getItems(),new TypeToken<List<TradeGoodsDTO>>(){}.getType());

        }catch (Exception e){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        return  purchaseDTO;
    }
}
