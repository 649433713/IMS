package IMS.demo.converter;

import IMS.demo.dataobject.OrderDetailPO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import IMS.demo.dto.OrderDTO;
import IMS.demo.enums.ResultEnum;
import IMS.demo.exceptions.CommonException;
import IMS.demo.form.OrderForm;

import java.util.List;

/**
 * @author IMS
 * Created on 2017/10/16
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetailPO> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetailPO>>(){}.getType());

        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new CommonException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailPOList(orderDetailList);

        return orderDTO;

    }
}
