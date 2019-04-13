package IMS.demo.service;

import IMS.demo.dto.PurchaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseService {

    /**创建进货*/
    PurchaseDTO purchase(PurchaseDTO purchaseDTO);

    /**查询进货列表*/
    Page<Package> findPurchaseList(Pageable pageable);
}
