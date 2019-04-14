package IMS.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import IMS.demo.converter.OrderForm2OrderDTOConverter;
import IMS.demo.dto.OrderDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.SellException;
import IMS.demo.form.OrderForm;
import IMS.demo.service.OrderService;
import IMS.demo.utils.ResultVOUtil;
import IMS.demo.vo.ResultVO;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author IMS
 * Created on 2017/10/16
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确,orderForm={}",orderForm);
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (orderDTO.getOrderDetailPOList().isEmpty()){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>(16);
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    @Cacheable(cacheNames = "orderDTO",key ="123")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size) {

        if (openid.isEmpty()){
            log.error("【查询订单列表】 openID为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {

        OrderDTO orderDTO = null;
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        return ResultVOUtil.success();
    }
}
