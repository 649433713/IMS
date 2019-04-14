package IMS.demo.controller;

import IMS.demo.converter.MemberForm2DTOConverter;
import IMS.demo.converter.OrderForm2OrderDTOConverter;
import IMS.demo.dto.GoodsDTO;
import IMS.demo.dto.MemberDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.SellException;
import IMS.demo.form.MemberForm;
import IMS.demo.service.GoodsService;
import IMS.demo.service.MemberService;
import IMS.demo.utils.ResultVOUtil;
import IMS.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    //商品列表
    @GetMapping("/")
    public ResultVO<List<MemberDTO>> list(@RequestParam(value = "cursor",defaultValue = "0") Integer cursor,
                                         @RequestParam(value = "count",defaultValue = "20") Integer count) {

        PageRequest request = new PageRequest(cursor,count);
        Page<MemberDTO> memberDTOPage = memberService.findList(request);

        return ResultVOUtil.success(memberDTOPage.getContent());
    }

    //创建商品
    @PostMapping("/add")
    public ResultVO<Map<String,String>> create(@Valid MemberForm memberForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        MemberDTO memberDTO = MemberForm2DTOConverter.convert(memberForm);
        MemberDTO createResult = memberService.create(memberDTO);

        return ResultVOUtil.success(createResult);
    }

    //编辑商品
    @PostMapping("/modify")
    public ResultVO<Map<String,String>> modify(@Valid MemberForm memberForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        MemberDTO memberDTO = MemberForm2DTOConverter.convert(memberForm);
        MemberDTO createResult = memberService.modify(memberDTO);

        return ResultVOUtil.success(createResult);
    }
}
