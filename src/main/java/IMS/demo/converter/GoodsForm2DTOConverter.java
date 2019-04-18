package IMS.demo.converter;

import IMS.demo.dto.GoodsDTO;
import IMS.demo.form.GoodsForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoodsForm2DTOConverter {
    public static GoodsDTO convert(GoodsForm goodsForm) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setBrand(goodsForm.getBrand());
        goodsDTO.setCategory(goodsForm.getCategory());
        goodsDTO.setDanwei(goodsForm.getDanwei());
        goodsDTO.setGoodsId(goodsForm.getGoodsId());
        goodsDTO.setName(goodsForm.getName());
        goodsDTO.setNote(goodsForm.getNote());
        goodsDTO.setPrice(goodsForm.getPrice());
        goodsDTO.setSize(goodsForm.getSize());
        goodsDTO.setWeight(goodsForm.getWeight());
        goodsDTO.setBestBeforeDate(goodsForm.getBestBeforeDate());
        goodsDTO.setPlaceOfOrigin(goodsForm.getPlaceOfOrigin());
        return goodsDTO;
    }

}
