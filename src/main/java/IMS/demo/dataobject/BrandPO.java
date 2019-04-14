package IMS.demo.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yinywf
 * Created on 2019/4/11
 */
@Entity
@Table(name = "brand_list", schema = "ims")
public class BrandPO {
    private String brand;

    @Id
    @Column(name = "brand", nullable = false, length = 45)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandPO that = (BrandPO) o;

        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return brand != null ? brand.hashCode() : 0;
    }
}
