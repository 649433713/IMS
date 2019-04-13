package IMS.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class GoodsForm {
    private String goodsId;
    @NotEmpty(message = "姓名必填")
    private String name;
    @NotEmpty(message = "类别必填")
    private String category;
    @NotEmpty(message = "品牌必填")
    private String brand;
    @NotEmpty(message = "规格必填")
    private String size;
    @NotEmpty(message = "单位必填")
    private String danwei;
    @NotEmpty(message = "重量必填")
    private double weight;
    private String note ;
    @NotEmpty(message = "价格必填")
    private double price;

    public String getSize() {
        return size;
    }

    public String getNote() {
        return note;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public String getDanwei() {
        return danwei;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
