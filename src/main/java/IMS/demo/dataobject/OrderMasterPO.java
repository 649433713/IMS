package IMS.demo.dataobject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author yinywf
 * Created on 2019/4/10
 */
@Entity
@Table(name = "order_master", schema = "ims", catalog = "")
public class OrderMasterPO {
    private String orderId;
    private String buyerName;
    private String buyerContact;
    private BigDecimal orderAmount;
    private byte orderStatus;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String orderAbstract;

    @Id
    @Column(name = "order_id", nullable = false, length = 32)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "buyer_name", nullable = false, length = 32)
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Basic
    @Column(name = "buyer_contact", nullable = false, length = 32)
    public String getBuyerContact() {
        return buyerContact;
    }

    public void setBuyerContact(String buyerContact) {
        this.buyerContact = buyerContact;
    }

    @Basic
    @Column(name = "order_amount", nullable = false, precision = 2)
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "order_status", nullable = false)
    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "order_abstract", nullable = true, length = 255)
    public String getOrderAbstract() {
        return orderAbstract;
    }

    public void setOrderAbstract(String orderAbstract) {
        this.orderAbstract = orderAbstract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderMasterPO that = (OrderMasterPO) o;

        if (orderStatus != that.orderStatus) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (buyerName != null ? !buyerName.equals(that.buyerName) : that.buyerName != null) return false;
        if (buyerContact != null ? !buyerContact.equals(that.buyerContact) : that.buyerContact != null) return false;
        if (orderAmount != null ? !orderAmount.equals(that.orderAmount) : that.orderAmount != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (orderAbstract != null ? !orderAbstract.equals(that.orderAbstract) : that.orderAbstract != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (buyerName != null ? buyerName.hashCode() : 0);
        result = 31 * result + (buyerContact != null ? buyerContact.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (int) orderStatus;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (orderAbstract != null ? orderAbstract.hashCode() : 0);
        return result;
    }
}
