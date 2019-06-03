package IMS.demo.converter;

import IMS.demo.dto.SaleDTO;
import IMS.demo.dto.SaleGoodsDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.CommonException;
import IMS.demo.form.SaleForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SaleForm2DTOConverter {
    public static SaleDTO convert(SaleForm saleForm) {
        SaleDTO saleDTO=new SaleDTO();
        saleDTO.setBuyer(saleForm.getBuyer());
        saleDTO.setCreateTime(saleForm.getCreateTime());
        saleDTO.setNote(saleForm.getNote());
        saleDTO.setSalesId(saleForm.getSaleId());
        saleDTO.setStatus(saleForm.getStatus());

        saleDTO.setTransport(saleForm.getTransport());
        List<SaleGoodsDTO> saleGoodsDTOList;
        Gson gson = new Gson();
        try {
            saleGoodsDTOList = gson.fromJson(saleForm.getGoodsList(),new TypeToken<List<SaleGoodsDTO>>(){}.getType());

        }catch (Exception e){
            throw new CommonException(ResultEnum.PARAM_ERROR);
        }
        saleDTO.setGoodsList(saleGoodsDTOList);
        return  saleDTO;
    }

}
