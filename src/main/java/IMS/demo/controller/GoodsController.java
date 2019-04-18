package IMS.demo.controller;

import IMS.demo.converter.GoodsForm2DTOConverter;
import IMS.demo.dto.GoodsDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.CommonException;
import IMS.demo.form.GoodsForm;
import IMS.demo.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import IMS.demo.utils.ResultVOUtil;
import IMS.demo.vo.ResultVO;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //商品列表
    @GetMapping("/")
    public ResultVO<List<GoodsDTO>> list(@RequestParam(value = "cursor",defaultValue = "0") Integer cursor,
                                         @RequestParam(value = "count",defaultValue = "20") Integer count) {

        PageRequest request = new PageRequest(cursor,count);
        Page<GoodsDTO> goodsDTOPage = goodsService.findList(request);

        return ResultVOUtil.success(goodsDTOPage.getContent());
    }

    //创建商品
    @PostMapping("/add")
    public ResultVO<Map<String,String>> create(@Valid GoodsForm goodsForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new CommonException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        GoodsDTO goodsDTO = GoodsForm2DTOConverter.convert(goodsForm);
        GoodsDTO createResult = goodsService.create(goodsDTO);

        return ResultVOUtil.success(createResult);
    }

    //编辑商品
    @PostMapping("/modify")
    public ResultVO<Map<String,String>> modify(@Valid GoodsForm goodsForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new CommonException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        GoodsDTO goodsDTO = GoodsForm2DTOConverter.convert(goodsForm);
        GoodsDTO createResult = goodsService.modify(goodsDTO);

        return ResultVOUtil.success(createResult);
    }
}
