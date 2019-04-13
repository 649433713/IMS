package IMS.demo.service.impl;

import IMS.demo.dto.PurchaseDTO;
import IMS.demo.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yinywf
 * Created on 2019/4/13
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SalesServiceImpl implements SalesService {
    @Override
    public PurchaseDTO sales(PurchaseDTO purchaseDTO) {
        return null;
    }
}
