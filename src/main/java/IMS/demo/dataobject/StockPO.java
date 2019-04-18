package IMS.demo.dataobject;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author yinywf
 * Created on 2019/4/18
 */
@Entity
@Table(name = "stock", schema = "ims")
public class StockPO {
    private String id;
    private String productId;
    private Integer quantity;
    private String place;
    private String logistics;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id", nullable = true, length = 32)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "place", nullable = true, length = 255)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "logistics", nullable = true, length = 512)
    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPO stockPO = (StockPO) o;
        return Objects.equals(id, stockPO.id) &&
                Objects.equals(productId, stockPO.productId) &&
                Objects.equals(quantity, stockPO.quantity) &&
                Objects.equals(place, stockPO.place) &&
                Objects.equals(logistics, stockPO.logistics);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, productId, quantity, place, logistics);
    }
}
