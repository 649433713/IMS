package IMS.demo.service;

import IMS.demo.dto.PurchaseDTO;

public interface SalesService {

    /**创建销售订单*/
    PurchaseDTO sales(PurchaseDTO purchaseDTO);
}
