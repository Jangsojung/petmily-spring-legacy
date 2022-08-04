package org.petmily.service;

import org.petmily.domain.member.Member;
import org.petmily.domain.member.form.JoinRequest;
import org.petmily.domain.member.form.MemberInfo;
import org.springframework.stereotype.Service;

public interface MemberService {

    public void join(JoinRequest joinReq);

    public Member login(String id, String pw);

    public void logout();

    public MemberInfo findById(String userId);

    public void withdraw(int mNumber);

    public boolean checkPwCorrect(int mNumber, String pw);

    public void changeMemberInfo(String id, MemberInfo memberInfo);
}
