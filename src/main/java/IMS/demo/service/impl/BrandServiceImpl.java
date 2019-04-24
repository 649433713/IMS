package IMS.demo.service.impl;

import IMS.demo.dataobject.BrandPO;
import IMS.demo.repository.BrandRepository;
import IMS.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/4/24
 */
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<BrandPO> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public boolean addBrand(String brand) {
        BrandPO brandPO = new BrandPO();
        brandPO.setBrand(brand);
        return brandRepository.save(brandPO) != null;
    }

    @Override
    public void deleteBrand(String brand) {
        brandRepository.delete(brand);
    }
}
