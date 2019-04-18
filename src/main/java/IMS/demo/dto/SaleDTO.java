package IMS.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class SaleDTO {
    private String salesId;
    private String note;
    private String status;
    private String buyer;
    private LocalDateTime createTime;

    List<TradeGoodsDTO> goodsList;
}
