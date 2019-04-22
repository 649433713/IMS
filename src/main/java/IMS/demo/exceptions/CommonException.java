package IMS.demo.exceptions;

import lombok.Getter;
import IMS.demo.enums.ResultEnum;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
@Getter
public class CommonException extends RuntimeException{

    private Integer code;

    public CommonException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public CommonException(String message){
        super(message);

        this.code = ResultEnum.PARAM_ERROR.getCode();
    }

    public CommonException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
    }
}
