package org.petmily.service;

import org.petmily.dao.MemberDao;
import org.petmily.domain.member.Member;
import org.petmily.domain.member.form.JoinRequest;
import org.petmily.domain.member.form.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired MemberDao memberDao;

    @Override
    public void join(JoinRequest joinReq) {
        Member member = toMember(joinReq);
        memberDao.insert(member);
    }

    @Override
    public Member login(String id, String pw) {
        Member member = memberDao.selectMemberById(id);

        if (!pw.equals(member.getPw())) {
            return null;
        }

        return member;
    }

    @Override
    public void logout() {

    }

    @Override
    public MemberInfo findById(String userId) {
        return null;
    }

    @Override
    public void withdraw(int mNumber) {

    }

    @Override
    public boolean checkPwCorrect(int mNumber, String pw) {
        return false;
    }

    @Override
    public void changeMemberInfo(String id, MemberInfo memberInfo) {

    }

    private Member toMember(JoinRequest joinReq) {
        String id = joinReq.getId();
        String pw = joinReq.getPw();
        String name = joinReq.getName();
        Date birth = joinReq.getBirth();
        String gender = joinReq.getGender();
        String email = joinReq.getEmail();
        String phone = joinReq.getPhone();

        return new Member(id, pw, name, birth, gender, email, phone);
    }
}
