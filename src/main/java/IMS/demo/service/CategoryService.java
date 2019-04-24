package IMS.demo.service;

import IMS.demo.dataobject.ProductCategoryPO;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/4/24
 */
public interface CategoryService {

    List<ProductCategoryPO> findAll();

    boolean addCategory(String categoryName);

    void deleteCategory(int categoryId);
}
