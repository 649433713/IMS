package IMS.demo.repository;


import IMS.demo.dataobject.StockPurchaseMasterPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface StockPurchaseMasterRepository extends JpaRepository<StockPurchaseMasterPO, Integer> {

}
