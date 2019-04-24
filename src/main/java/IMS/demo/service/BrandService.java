package IMS.demo.service;

import IMS.demo.dto.BrandDTO;

import java.util.List;

public interface BrandService {
    /**获取列表*/
    //todo
    List<BrandDTO> findList();

    /**创建*/
    //todo
    BrandDTO create(BrandDTO buyerDTO);

    /**修改*/
    //todo
    BrandDTO modify(BrandDTO buyerDTO);

    /**删除*/
    //todo
    BrandDTO del(BrandDTO buyerDTO);
}
