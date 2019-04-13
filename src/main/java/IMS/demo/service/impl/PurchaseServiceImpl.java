package IMS.demo.service.impl;

import IMS.demo.dto.PurchaseDTO;
import IMS.demo.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yinywf
 * Created on 2019/4/13
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PurchaseServiceImpl implements PurchaseService {
    @Override
    public PurchaseDTO purchase(PurchaseDTO purchaseDTO) {
        return null;
    }

    @Override
    public Page<Package> findPurchaseList(Pageable pageable) {
        return null;
    }
}
