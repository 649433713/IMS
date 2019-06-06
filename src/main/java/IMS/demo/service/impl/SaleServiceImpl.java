package IMS.demo.service.impl;

import IMS.demo.dataobject.OrderDetailPO;
import IMS.demo.dataobject.OrderMasterPO;
import IMS.demo.dto.SaleDTO;
import IMS.demo.dto.SaleGoodsDTO;
import IMS.demo.repository.OrderDetailRepository;
import IMS.demo.repository.OrderMasterRepository;
import IMS.demo.service.SalesService;
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
public class SaleServiceImpl implements SalesService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public SaleDTO sales(SaleDTO SaleDTO) {
        OrderMasterPO masterPO = SaleDTO.transferMasterPO();
        List<OrderDetailPO> orderDetailPOS = SaleDTO.transferDetailPOs();

        orderMasterRepository.save(masterPO);
        orderDetailRepository.save(orderDetailPOS);
        return SaleDTO;
    }

    @Override
    public Page<SaleDTO> findSalesList(Pageable pageable) {
        Page<OrderMasterPO> orderMasterPOS = orderMasterRepository.findAll(pageable);

        return orderMasterPOS.map(orderMasterPO -> new SaleDTO(orderMasterPO, orderDetailRepository.findByOrderId(orderMasterPO.getOrderId())));
    }

    @Override
    public List<SaleGoodsDTO> findSaleDetail(String saleID) {
        return orderDetailRepository.findByOrderId(saleID).stream().map(SaleGoodsDTO::new).collect(Collectors.toList());
    }

}
