package IMS.demo.service.impl;

import IMS.demo.dataobject.BuyerInfoPO;
import IMS.demo.dto.BuyerDTO;
import IMS.demo.repository.BuyerInfoRepository;
import IMS.demo.service.BuyerService;
import IMS.demo.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author yinywf
 * Created on 2019/4/13
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerInfoRepository buyerInfoRepository;
    @Override
    public Page<BuyerDTO> findList(Pageable pageable) {

        Page<BuyerInfoPO> buyerInfoPOS = buyerInfoRepository.findAll(pageable);
        return buyerInfoPOS.map(BuyerDTO::new);
    }

    @Override
    public BuyerDTO create(BuyerDTO buyerDTO) {
        BuyerInfoPO savePo = buyerDTO.transferPO();
        savePo.setId(KeyUtil.getUniqueKey());
        BuyerInfoPO buyerInfoPO = buyerInfoRepository.save(savePo);
        return new BuyerDTO(buyerInfoPO);
    }

    @Override
    public BuyerDTO modify(BuyerDTO buyerDTO) {
        BuyerInfoPO buyerInfoPO = buyerInfoRepository.save(buyerDTO.transferPO());
        return new BuyerDTO(buyerInfoPO);
    }

    @Override
    public BuyerDTO del(BuyerDTO buyerDTO) {
        buyerInfoRepository.delete(buyerDTO.getBuyerId());
        return buyerDTO;
    }

    @Override
    public ArrayList<String> findBuyerNames() {
        return buyerInfoRepository.findNames();
    }
}
