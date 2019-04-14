package IMS.demo.repository;


import IMS.demo.dataobject.ProductInfoPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfoPO, String> {

    @Query(value="select b.productName from ProductInfoPO b")
    List<String> findNames();
}
