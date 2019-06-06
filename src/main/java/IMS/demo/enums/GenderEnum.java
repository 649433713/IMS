package IMS.demo.enums;

import lombok.Getter;

/**
 * @author yinywf
 * Created on 2019/6/6
 */
@Getter
public enum GenderEnum implements CodeEnum{
    MAN(0, "男"),
    WOMAN(1, "女"),
    NULL(2, "未知");

    private Integer code;
    private String message;

    GenderEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String valueOf(byte b) {
        return GenderEnum.values()[b].message;
    }

}
