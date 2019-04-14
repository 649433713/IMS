package IMS.demo.dataobject;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author yinywf
 * Created on 2019/4/14
 */
@Entity
@Table(name = "stock_purchase_master", schema = "ims")
public class StockPurchaseMasterPO {
    private int id;
    private LocalDateTime createTime;
    private String comments;
    private String seller;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "create_time", nullable = true, length = 45)
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 512)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "seller", nullable = true, length = 45)
    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPurchaseMasterPO that = (StockPurchaseMasterPO) o;
        return id == that.id &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(seller, that.seller);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createTime, comments, seller);
    }
}
