package IMS.demo.dataobject;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author yinywf
 * Created on 2019/4/10
 */
@Entity
@Table(name = "customer", schema = "ims")
@DynamicUpdate
@DynamicInsert
public class CustomerPO {
    private String cardNo;
    private String customerName;
    private String type;
    private Double balance;
    private String contact;
    private String comments;
    private String email;

    @Id
    @Column(name = "card_no", nullable = false, length = 45)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "customer_name", nullable = true, length = 45)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 0)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "contact", nullable = true, length = 45)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 45)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 512)
    public String getEmail() {
        return email;
    }

    public void setEmail(String invoiceInfo) {
        this.email = invoiceInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerPO that = (CustomerPO) o;

        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardNo != null ? cardNo.hashCode() : 0;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
