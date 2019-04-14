package IMS.demo.repository;


import IMS.demo.dataobject.CustomerPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface CustomerRepository extends JpaRepository<CustomerPO, String> {

    @Query(value="select b.customerName from CustomerPO b")
    List<String> findNames();
}
