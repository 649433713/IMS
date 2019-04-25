package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetailPO;
import IMS.demo.dataobject.OrderMasterPO;
import IMS.demo.enums.OrderStatusEnum;
import IMS.demo.utils.EnumUtil;
import IMS.demo.utils.KeyUtil;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SaleDTO {
    private String salesId;
    private String note;
    private String status;
    private String buyer;
    private LocalDateTime createTime;

    List<SaleGoodsDTO> goodsList;

    public SaleDTO(OrderMasterPO orderMasterPO, List<OrderDetailPO> orderDetailPOS) {
        salesId = orderMasterPO.getOrderId();
        note = orderMasterPO.getOrderAbstract();
        status = EnumUtil.getByCode((int) orderMasterPO.getOrderStatus(),OrderStatusEnum.class).getMessage();
        buyer = orderMasterPO.getBuyerName();
        createTime = orderMasterPO.getCreateTime().toLocalDateTime();
        goodsList = orderDetailPOS == null ? null : orderDetailPOS.stream().map(SaleGoodsDTO::new).collect(Collectors.toList());
    }

    public OrderMasterPO transferMasterPO() {
        OrderMasterPO orderMasterPO = new OrderMasterPO();
        orderMasterPO.setOrderId(salesId == null ? KeyUtil.getUniqueKey() : salesId);
        orderMasterPO.setOrderAbstract(note);
        orderMasterPO.setOrderStatus(EnumUtil.getByMessage(status,OrderStatusEnum.class).getCode().byteValue());
        orderMasterPO.setBuyerName(buyer);
        return orderMasterPO;
    }

    public List<OrderDetailPO> transferDetailPOs() {
        return goodsList.stream().map(SaleGoodsDTO::transferPO).collect(Collectors.toList());
    }

    public SaleDTO() {

    }

}
