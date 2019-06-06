package IMS.demo.controller;

import IMS.demo.dto.SaleDTO;
import IMS.demo.dto.SaleGoodsDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.CommonException;
import IMS.demo.repository.OrderDetailRepository;
import IMS.demo.repository.OrderMasterRepository;
import IMS.demo.service.SalesService;
import IMS.demo.utils.ResultVOUtil;
import IMS.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SalesService salesService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

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
    public ResultVO<List<SaleGoodsDTO>> detail(@RequestParam("saleID") String saleID) {

        List<SaleGoodsDTO> saleDetail= salesService.findSaleDetail(saleID);
        return ResultVOUtil.success(saleDetail);
    }
    //创建
    @PostMapping("/add")
    public ResultVO<SaleDTO> create(@RequestBody SaleDTO saleDTO, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new CommonException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        SaleDTO createResult = salesService.sales(saleDTO);

        return ResultVOUtil.success(createResult);
    }

}
