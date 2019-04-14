package IMS.demo.service.impl;

import IMS.demo.dataobject.BrandPO;
import IMS.demo.dataobject.ProductInfoPO;
import IMS.demo.dto.GoodsDTO;
import IMS.demo.repository.BrandRepository;
import IMS.demo.repository.ProductCategoryRepository;
import IMS.demo.repository.ProductInfoRepository;
import IMS.demo.service.GoodsService;
import IMS.demo.utils.KeyUtil;
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
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public Page<GoodsDTO> findList(Pageable pageable) {
        Page<ProductInfoPO> productInfoPOS = productInfoRepository.findAll(pageable);
        return productInfoPOS.map(GoodsDTO::new);
    }

    @Override
    public GoodsDTO create(GoodsDTO goodsDTO) {
        ProductInfoPO savePo = goodsDTO.getPo();
        savePo.setProductId(KeyUtil.getUniqueKey());
        return new GoodsDTO(productInfoRepository.save(savePo));
    }

    @Override
    public GoodsDTO modify(GoodsDTO goodsDTO) {
        ProductInfoPO productInfoPO = productInfoRepository.save(goodsDTO.getPo());
        return new GoodsDTO(productInfoPO);
    }

    @Override
    public GoodsDTO del(GoodsDTO goodsDTO) {
        productInfoRepository.delete(goodsDTO.getGoodsId());
        return goodsDTO;
    }

    @Override
    public List<String> findAllBrands() {
        return brandRepository.findAll().stream().map(BrandPO::getBrand).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllNames() {
        return productInfoRepository.findNames();
    }

    @Override
    public List<String> findAllCategory() {
        return productCategoryRepository.findNames();
    }
}
