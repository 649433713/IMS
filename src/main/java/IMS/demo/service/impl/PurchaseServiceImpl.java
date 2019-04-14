package IMS.demo.service.impl;

import IMS.demo.dataobject.StockPurchaseMasterPO;
import IMS.demo.dataobject.StockPurchasePO;
import IMS.demo.dto.PurchaseDTO;
import IMS.demo.dto.TradeGoodsDTO;
import IMS.demo.repository.StockPurchaseMasterRepository;
import IMS.demo.repository.StockPurchaseRepository;
import IMS.demo.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yinywf
 * Created on 2019/4/13
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private StockPurchaseMasterRepository stockPurchaseMasterRepository;

    @Autowired
    private StockPurchaseRepository stockPurchaseRepository;

    @Override
    public PurchaseDTO purchase(PurchaseDTO purchaseDTO) {
        StockPurchaseMasterPO masterPO = new StockPurchaseMasterPO();
        masterPO.setComments(purchaseDTO.getNote());
        int masterId = stockPurchaseMasterRepository.save(masterPO).getId();
        List<TradeGoodsDTO> tradeGoodsDTOS = purchaseDTO.getGoodsList();
        List<StockPurchasePO> stockPurchasePOS = tradeGoodsDTOS.stream().map(tradeGoodsDTO -> {
            StockPurchasePO stockPurchasePO = tradeGoodsDTO.getPO();
            stockPurchasePO.setMasterId(masterId);
            return stockPurchasePO;
        }).collect(Collectors.toList());
        stockPurchaseRepository.save(stockPurchasePOS);

        return purchaseDTO;
    }

    @Override
    public Page<PurchaseDTO> findPurchaseList(Pageable pageable) {
        Page<StockPurchaseMasterPO> stockPurchaseMasterPOS = stockPurchaseMasterRepository.findAll(pageable);
        return stockPurchaseMasterPOS.map(stockPurchaseMasterPO ->{
            PurchaseDTO purchaseDTO = new PurchaseDTO();
            purchaseDTO.setCreateTime(stockPurchaseMasterPO.getCreateTime());
            purchaseDTO.setNote(stockPurchaseMasterPO.getComments());
            purchaseDTO.setPurchaseId(String.valueOf(stockPurchaseMasterPO.getId()));

            List<StockPurchasePO> stockPurchasePOS = stockPurchaseRepository.findByMasterId(stockPurchaseMasterPO.getId());
            List<TradeGoodsDTO> tradeGoodsDTOS = stockPurchasePOS.stream().map(TradeGoodsDTO::new).collect(Collectors.toList());
            purchaseDTO.setGoodsList(tradeGoodsDTOS);
            return purchaseDTO;
        });

    }

}
