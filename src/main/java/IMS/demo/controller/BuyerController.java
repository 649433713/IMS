package IMS.demo.controller;

import IMS.demo.converter.BuyerForm2DTOConverter;
import IMS.demo.converter.OrderForm2OrderDTOConverter;
import IMS.demo.dto.BuyerDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.SellException;
import IMS.demo.form.BuyerForm;
import IMS.demo.service.BuyerService;
import IMS.demo.utils.ResultVOUtil;
import IMS.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    //商品列表
    @GetMapping("/")
    public ResultVO<List<BuyerDTO>> list(@RequestParam(value = "cursor",defaultValue = "0") Integer cursor,
                                          @RequestParam(value = "count",defaultValue = "20") Integer count) {

        PageRequest request = new PageRequest(cursor,count);
        Page<BuyerDTO> buyerDTOPage = buyerService.findList(request);

        return ResultVOUtil.success(buyerDTOPage.getContent());
    }

    //创建商品
    @PostMapping("/add")
    public ResultVO<Map<String,String>> create(@Valid BuyerForm buyerForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        BuyerDTO buyerDTO = BuyerForm2DTOConverter.convert(buyerForm);
        BuyerDTO createResult = buyerService.create(buyerDTO);

        return ResultVOUtil.success(createResult);
    }

    //编辑商品
    @PostMapping("/modify")
    public ResultVO<Map<String,String>> modify(@Valid BuyerForm buyerForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        BuyerDTO buyerDTO = BuyerForm2DTOConverter.convert(buyerForm);
        BuyerDTO createResult = buyerService.modify(buyerDTO);

        return ResultVOUtil.success(createResult);
    }
}
