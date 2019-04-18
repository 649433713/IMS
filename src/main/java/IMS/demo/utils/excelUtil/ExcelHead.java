package IMS.demo.utils.excelUtil;

import IMS.demo.dataobject.BuyerInfoPO;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author yinywf
 * Created on 2019/4/18
 */
public class ExcelHead {
    private String excelName;             //Excel名
    private String entityName;            //实体类属性名
    private boolean required=false;      //值必填

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public ExcelHead(String excelName, String entityName, boolean required) {
        this.excelName = excelName;
        this.entityName = entityName;
        this.required = required;
    }

    public ExcelHead(String excelName, String entityName) {
        this.excelName = excelName;
        this.entityName = entityName;
    }

    public ExcelHead(){}

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("./ExcelTest.xlsx"));
            System.out.println(ExcelUtil.readExcelToEntity(BuyerInfoPO.class, fileInputStream, "ExcelTest.xlsx"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

