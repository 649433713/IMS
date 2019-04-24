package IMS.demo.service;

import IMS.demo.dto.SaleDTO;
import IMS.demo.dto.PurchaseGoodsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalesService {

    /**创建销售订单*/
    //TODO
    SaleDTO sales(SaleDTO SaleDTO);
    //TODO
    /**查询进货列表*/
    Page<SaleDTO> findSalesList(Pageable pageable);
    //TODO
    /**查询销售详情*/
    List<PurchaseGoodsDTO> findSaleDetail(String saleID);
}
