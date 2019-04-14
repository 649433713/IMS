package IMS.demo.service;

import IMS.demo.dto.GoodsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {
    /**查询商品列表*/
    Page<GoodsDTO> findList(Pageable pageable);

    /**创建商品*/
    GoodsDTO create(GoodsDTO goodsDTO);

    /**修改商品*/
    GoodsDTO modify(GoodsDTO goodsDTO);

    /**删除商品*/
    GoodsDTO del(GoodsDTO goodsDTO);

    /**获取所有商品品牌*/
    List<String> findAllBrands();

    /**获取所有商品名*/
    List<String> findAllNames();

    /**获取所有商品种类*/
    List<String> findAllCategory();

}
