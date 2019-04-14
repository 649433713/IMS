package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetailPO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO{

    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus ;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    List<OrderDetailPO> orderDetailPOList;

}
