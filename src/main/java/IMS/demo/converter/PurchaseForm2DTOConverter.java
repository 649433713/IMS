package IMS.demo.converter;

import IMS.demo.dto.PurchaseDTO;
import IMS.demo.dto.TradeGoodsDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.CommonException;
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

        List<TradeGoodsDTO> tradeGoodsDTOList;
        Gson gson = new Gson();
        try {
            tradeGoodsDTOList = gson.fromJson(purchaseForm.getGoodsList(),new TypeToken<List<TradeGoodsDTO>>(){}.getType());

        }catch (Exception e){
            throw new CommonException(ResultEnum.PARAM_ERROR);
        }
        purchaseDTO.setGoodsList(tradeGoodsDTOList);
        return  purchaseDTO;
    }
}
