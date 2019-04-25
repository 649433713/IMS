package IMS.demo.service.impl;

import IMS.demo.dataobject.CustomerPO;
import IMS.demo.dto.MemberDTO;
import IMS.demo.repository.CustomerRepository;
import IMS.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yinywf
 * Created on 2019/4/13
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<MemberDTO> findList(Pageable pageable) {
        Page<CustomerPO> customerPOS = customerRepository.findAll(pageable);
        return customerPOS.map(MemberDTO::new);
    }

    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        CustomerPO savePo = memberDTO.transferPO();

        return new MemberDTO(customerRepository.save(savePo));
    }

    @Override
    public MemberDTO modify(MemberDTO memberDTO) {

        return new MemberDTO(customerRepository.save(memberDTO.transferPO()));
    }

    @Override
    public MemberDTO del(MemberDTO memberDTO) {
        customerRepository.delete(memberDTO.getMemberId());
        return memberDTO;
    }

    @Override
    public List<String> findMemberNames() {
        return customerRepository.findNames();
    }
}
