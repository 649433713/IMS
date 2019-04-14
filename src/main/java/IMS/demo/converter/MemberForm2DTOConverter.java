package IMS.demo.converter;

import IMS.demo.dto.MemberDTO;
import IMS.demo.form.MemberForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberForm2DTOConverter {
    public static MemberDTO convert(MemberForm memberForm) {
        MemberDTO memberDTO=new MemberDTO();
        memberDTO.setMemberId(memberForm.getMemberId());
        memberDTO.setMemberName(memberForm.getMemberName());
        memberDTO.setNote(memberForm.getNote());
        memberDTO.setBalance(memberForm.getBalance());
        memberDTO.setTel(memberForm.getTel());
        return memberDTO;
    }
}
