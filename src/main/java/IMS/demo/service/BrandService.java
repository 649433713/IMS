package IMS.demo.service;

import IMS.demo.dataobject.BrandPO;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/4/24
 */
public interface BrandService {

    List<BrandPO> findAll();

    boolean addBrand(String brand);

    void deleteBrand(String brand);

}
