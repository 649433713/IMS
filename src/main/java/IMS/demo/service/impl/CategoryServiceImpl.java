package IMS.demo.service.impl;

import IMS.demo.dataobject.ProductCategoryPO;
import IMS.demo.repository.ProductCategoryRepository;
import IMS.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/4/24
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;
    @Override
    public List<ProductCategoryPO> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean addCategory(String categoryName) {
        return categoryRepository.save(new ProductCategoryPO(categoryName)) != null;
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.delete(categoryId);
    }
}
