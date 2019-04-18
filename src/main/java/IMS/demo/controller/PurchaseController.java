package IMS.demo.controller;

import IMS.demo.converter.PurchaseForm2DTOConverter;
import IMS.demo.dto.PurchaseDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.CommonException;
import IMS.demo.form.PurchaseForm;
import IMS.demo.service.PurchaseService;
import IMS.demo.utils.ResultVOUtil;
import IMS.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    //创建商品
    @PostMapping("/add")
    public ResultVO<Map<String,String>> create(@Valid PurchaseForm purchaseForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new CommonException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        PurchaseDTO purchaseDTO = PurchaseForm2DTOConverter.convert(purchaseForm);
        PurchaseDTO createResult = purchaseService.purchase(purchaseDTO);

        return ResultVOUtil.success();
    }
}
