package IMS.demo.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author yinywf
 * Created on 2019/4/10
 */
@Entity
@Table(name = "stock_check", schema = "ims", catalog = "")
@IdClass(StockCheckPOPK.class)
public class StockCheckPO {
    private String productId;
    private Integer adjustQuantity;
    private Timestamp adjustTime;

    @Id
    @Column(name = "product_id", nullable = false, length = 32)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "adjust_quantity", nullable = true)
    public Integer getAdjustQuantity() {
        return adjustQuantity;
    }

    public void setAdjustQuantity(Integer adjustQuantity) {
        this.adjustQuantity = adjustQuantity;
    }

    @Id
    @Column(name = "adjust_time", nullable = false)
    public Timestamp getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Timestamp adjustTime) {
        this.adjustTime = adjustTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockCheckPO that = (StockCheckPO) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (adjustQuantity != null ? !adjustQuantity.equals(that.adjustQuantity) : that.adjustQuantity != null)
            return false;
        if (adjustTime != null ? !adjustTime.equals(that.adjustTime) : that.adjustTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (adjustQuantity != null ? adjustQuantity.hashCode() : 0);
        result = 31 * result + (adjustTime != null ? adjustTime.hashCode() : 0);
        return result;
    }
}
