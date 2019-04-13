package IMS.demo.service.impl;

import IMS.demo.dto.GoodsDTO;
import IMS.demo.service.GoodsService;
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
public class GoodsServiceImpl implements GoodsService {
    @Override
    public Page<GoodsDTO> findList(Pageable pageable) {
        return null;
    }

    @Override
    public GoodsDTO create(GoodsDTO goodsDTO) {
        return null;
    }

    @Override
    public GoodsDTO modify(GoodsDTO goodsDTO) {
        return null;
    }

    @Override
    public GoodsDTO del(GoodsDTO goodsDTO) {
        return null;
    }

    @Override
    public ArrayList<String> findAllBrands() {
        return null;
    }

    @Override
    public ArrayList<String> findAllNames() {
        return null;
    }

    @Override
    public ArrayList<String> findAllCategory() {
        return null;
    }
}
