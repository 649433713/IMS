package IMS.demo.service;

import IMS.demo.dto.BuyerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface BuyerService {
    /**获取进货商列表*/
    Page<BuyerDTO> findList(Pageable pageable);

    /**创建进货商*/
    BuyerDTO create(BuyerDTO buyerDTO);

    /**修改进货商*/
    BuyerDTO modify(BuyerDTO buyerDTO);

    /**删除进货商*/
    BuyerDTO del(BuyerDTO buyerDTO);

    /**获取所有进货商名称*/
    ArrayList<String> findBuyerNames();
}
