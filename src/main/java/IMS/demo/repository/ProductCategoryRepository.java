package IMS.demo.repository;


import IMS.demo.dataobject.ProductCategoryPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryPO, Integer> {

    @Query(value="select b.categoryName from ProductCategoryPO b")
    List<String> findNames();
}
