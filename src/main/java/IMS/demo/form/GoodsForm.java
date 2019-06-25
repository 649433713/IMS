package IMS.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class GoodsForm {
    private String goodsId;
    @NotEmpty(message = "姓名必填")
    private String name;

    private String shortName;

    @NotEmpty(message = "类别必填")
    private String category;
    @NotEmpty(message = "品牌必填")
    private String brand;
    @NotEmpty(message = "规格必填")
    private String size;
    @NotEmpty(message = "单位必填")
    private String danwei;
    @NotNull(message = "重量必填")
    private double weight;
    private String note ;
    @NotNull(message = "价格必填")
    private double price;
    private String placeOfOrigin;
    private Integer bestBeforeDate;

    private String color;
    private String articleNumber;
    // @NotNull(message = "材料必填")
    private String material;//材料
    // @NotNull(message = "型号必填")
    private String model;


}
