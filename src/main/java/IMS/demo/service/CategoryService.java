package IMS.demo.service;

import IMS.demo.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    /**获取列表*/
    //todo
    List<CategoryDTO> findList();

    /**创建*/
    //todo
    CategoryDTO create(CategoryDTO buyerDTO);

    /**修改*/
    //todo
    CategoryDTO modify(CategoryDTO buyerDTO);

    /**删除*/
    //todo
    CategoryDTO del(CategoryDTO buyerDTO);
}
