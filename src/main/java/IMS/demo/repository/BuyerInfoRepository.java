package IMS.demo.repository;


import IMS.demo.dataobject.BuyerInfoPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface BuyerInfoRepository extends JpaRepository<BuyerInfoPO, String> {

    @Query(value="select b.name from BuyerInfoPO b")
    ArrayList<String> findNames();


}
