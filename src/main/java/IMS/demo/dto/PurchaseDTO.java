package IMS.demo.dto;

import IMS.demo.dataobject.OrderDetail;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseDTO {
    private String purchaseId;
    private String note;
    private LocalDateTime createTime;
    List<TradeGoodsDTO> goodsList;

    public void setNote(String note) {
        this.note = note;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setGoodsList(List<TradeGoodsDTO> goodsList) {
        this.goodsList = goodsList;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }
}
