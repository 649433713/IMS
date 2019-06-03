package IMS.demo.service;

import IMS.demo.dto.CategoryDTO;
import IMS.demo.dto.MemberDTO;
import IMS.demo.dto.SaleDTO;

import java.util.List;
import java.util.Map;

public interface ReportFormService {
    //todo
    /**前一天分类销售额*/
    Map<String,Double> getCategoryEarningYesterday();

    //todo
    /**查询前一天订单*/
    List<SaleDTO> findOrderListYesterday();

    //todo
    /**查询前一天新增的用户*/
    List<MemberDTO> findNewMemberYesterday();

    //todo
    /**查询top5分类的销售额和金额和数量*/
    List<CategoryDTO> findTOP5Category();




}
