package IMS.demo.dataobject;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author yinywf
 * Created on 2019/4/10
 */
public class StockCheckPOPK implements Serializable {
    private String productId;
    private Timestamp adjustTime;

    @Column(name = "product_id", nullable = false, length = 32)
    @Id
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Column(name = "adjust_time", nullable = false)
    @Id
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

        StockCheckPOPK that = (StockCheckPOPK) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (adjustTime != null ? !adjustTime.equals(that.adjustTime) : that.adjustTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (adjustTime != null ? adjustTime.hashCode() : 0);
        return result;
    }
}
