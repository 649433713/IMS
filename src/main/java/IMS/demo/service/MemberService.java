package IMS.demo.service;

import IMS.demo.dto.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MemberService {
    /**获取用户列表*/
    Page<MemberDTO> findList(Pageable pageable);

    /**创建用户*/
    MemberDTO create(MemberDTO memberDTO);

    /**修改用户*/
    MemberDTO modify(MemberDTO memberDTO);

    /**删除用户*/
    MemberDTO del(MemberDTO memberDTO);

    /**获取所有用户名称*/
    List<String> findMemberNames();
}
