package IMS.demo.utils.excelUtil;



import java.lang.annotation.*;

/**
 * @author yinywf
 * @Description: 实体字段与excel列号关联的注解
 * Created on 2019/4/18
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelCell {
    String value();
    Class<?> Type() default String.class;

}