package IMS.demo.service.impl;

import IMS.demo.dto.SaleDTO;
import IMS.demo.dto.PurchaseGoodsDTO;
import IMS.demo.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/4/13
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SaleServiceImpl implements SalesService {
   @Override
    public SaleDTO sales(SaleDTO SaleDTO) {
        return null;
    }

    @Override
    public Page<SaleDTO> findSalesList(Pageable pageable) {
        return null;
    }

    @Override
    public List<PurchaseGoodsDTO> findSaleDetail(String saleID) {
        return null;
    }
}
