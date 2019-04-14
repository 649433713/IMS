package IMS.demo.repository;


import IMS.demo.dataobject.OrderDetailPO;
import IMS.demo.dataobject.StockCheckPO;
import IMS.demo.dataobject.StockCheckPOPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface StockCheckRepository extends JpaRepository<StockCheckPO, StockCheckPOPK> {

}
