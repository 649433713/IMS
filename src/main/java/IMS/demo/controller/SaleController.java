package IMS.demo.controller;

import IMS.demo.converter.SaleForm2DTOConverter;
import IMS.demo.dto.*;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.SellException;
import IMS.demo.form.SaleForm;
import IMS.demo.service.SalesService;
import IMS.demo.utils.ResultVOUtil;
import IMS.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SalesService salesService;
    //列表
    @GetMapping("/")
    public ResultVO<List<SaleDTO>> list(@RequestParam(value = "cursor",defaultValue = "0") Integer cursor,
                                         @RequestParam(value = "count",defaultValue = "20") Integer count) {

        PageRequest request = new PageRequest(cursor,count);
        Page<SaleDTO> saleDTOS = salesService.findSalesList(request);

        return ResultVOUtil.success(saleDTOS.getContent());
    }
    //详情
    @GetMapping("/detail")
    public ResultVO<List<PurchaseGoodsDTO>> detail(@RequestParam("saleID") String saleID) {

        List<PurchaseGoodsDTO> saleDetail= salesService.findSaleDetail(saleID);
        return ResultVOUtil.success(saleDetail);
    }
    //创建
    @PostMapping("/add")
    public ResultVO<Map<String,String>> create(@Valid SaleForm saleForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        SaleDTO saleDTO = SaleForm2DTOConverter.convert(saleForm);
        SaleDTO createResult = salesService.sales(saleDTO);

        return ResultVOUtil.success();
    }

}
