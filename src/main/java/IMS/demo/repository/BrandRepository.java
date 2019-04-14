package IMS.demo.repository;


import IMS.demo.dataobject.BrandPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public interface BrandRepository extends JpaRepository<BrandPO, String> {

}
