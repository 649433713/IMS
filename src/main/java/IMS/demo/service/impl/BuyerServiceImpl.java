package IMS.demo.service.impl;

import IMS.demo.dto.BuyerDTO;
import IMS.demo.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
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
    @Override
    public Page<BuyerDTO> findList(Pageable pageable) {
        return null;
    }

    @Override
    public BuyerDTO create(BuyerDTO buyerDTO) {
        return null;
    }

    @Override
    public BuyerDTO modify(BuyerDTO buyerDTO) {
        return null;
    }

    @Override
    public BuyerDTO del(BuyerDTO buyerDTO) {
        return null;
    }

    @Override
    public ArrayList<String> findBuyerNames() {
        return null;
    }
}
