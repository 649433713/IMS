package IMS.demo.service;

import IMS.demo.dto.SaleDTO;
import IMS.demo.dto.TradeGoodsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalesService {

    /**创建销售订单*/
    SaleDTO sales(SaleDTO SaleDTO);

    /**查询进货列表*/
    Page<SaleDTO> findSalesList(Pageable pageable);

    /**查询销售详情*/
    List<TradeGoodsDTO> findSaleDetail(String saleID);
}
