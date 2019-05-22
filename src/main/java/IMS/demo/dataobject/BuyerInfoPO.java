package IMS.demo.dataobject;

import IMS.demo.utils.excelUtil.ExcelCell;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author yinywf
 * Created on 2019/4/10
 */
@Entity
@Table(name = "buyer_info", schema = "ims")
@DynamicUpdate
@DynamicInsert
@ToString
public class BuyerInfoPO {
    @ExcelCell("编号")
    private String id;
    @ExcelCell("名称")
    private String name;
    private String contact;
    private String contactPerson;
    private String comments;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String productionCategory;
    private String legalPerson;
    private String email;
    private Byte gender;
    private String purchaseCategory;
    private String duty;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "contact", nullable = false, length = 32)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 64)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
    @Column(name = "contact_person", nullable = true, length = 45)
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Basic
    @Column(name = "production_category", nullable = true, length = 45)
    public String getProductionCategory() {
        return productionCategory;
    }

    public void setProductionCategory(String productionCategory) {
        this.productionCategory = productionCategory;
    }

    @Basic
    @Column(name = "legal_person", nullable = true, length = 45)
    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerInfoPO that = (BuyerInfoPO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(contactPerson, that.contactPerson) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(productionCategory, that.productionCategory) &&
                Objects.equals(legalPerson, that.legalPerson) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, contact, contactPerson, comments, createTime, updateTime, productionCategory, legalPerson, email);
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "purchase_category", nullable = true, length = 45)
    public String getPurchaseCategory() {
        return purchaseCategory;
    }

    public void setPurchaseCategory(String purchaseCategory) {
        this.purchaseCategory = purchaseCategory;
    }

    @Basic
    @Column(name = "duty", nullable = true, length = 45)
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
