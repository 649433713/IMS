package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetailPO;
import IMS.demo.dataobject.OrderMasterPO;
import IMS.demo.enums.OrderStatusEnum;
import IMS.demo.utils.EnumUtil;
import IMS.demo.utils.KeyUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleDTO {
    private String orderId;
    private String buyerName;
    private String buyerContact;
    private BigDecimal orderAmount;
    private String orderStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String orderAbstract;

    List<OrderDetailPO> goodsList;

    public SaleDTO(OrderMasterPO orderMasterPO, List<OrderDetailPO> orderDetailPOS) {

        BeanUtils.copyProperties(orderMasterPO,this);
        orderStatus = EnumUtil.getByCode((int) orderMasterPO.getOrderStatus(),OrderStatusEnum.class).getMessage();
        updateTime = orderMasterPO.getUpdateTime().toLocalDateTime();
        createTime = orderMasterPO.getCreateTime().toLocalDateTime();
        goodsList = orderDetailPOS;

    }

    public OrderMasterPO transferMasterPO() {
        OrderMasterPO orderMasterPO = new OrderMasterPO();
        orderMasterPO.setOrderId(orderId == null ? KeyUtil.getUniqueKey() : orderId);
        orderMasterPO.setOrderStatus(EnumUtil.getByMessage(orderStatus,OrderStatusEnum.class).getCode().byteValue());
        BeanUtils.copyProperties(this, orderMasterPO);
        return orderMasterPO;
    }

    public List<OrderDetailPO> transferDetailPOs() {
        return goodsList;
    }

    public SaleDTO() {

    }

}
