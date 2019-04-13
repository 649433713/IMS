package IMS.demo.service.impl;

import IMS.demo.dto.MemberDTO;
import IMS.demo.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

/**
 * @author yinywf
 * Created on 2019/4/13
 */
public class MemberServiceImpl implements MemberService {
    @Override
    public Page<MemberDTO> findList(Pageable pageable) {
        return null;
    }

    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public MemberDTO modify(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public MemberDTO del(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public ArrayList<String> findMemberNames() {
        return null;
    }
}
