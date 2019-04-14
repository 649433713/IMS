package IMS.demo.repository;


import IMS.demo.dataobject.CustomerPO;
import IMS.demo.dataobject.OrderDetailPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface CustomerRepository extends JpaRepository<CustomerPO, String> {

}
