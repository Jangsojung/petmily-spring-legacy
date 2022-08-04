package org.petmily.dao;

import org.petmily.domain.DomainObj;
import org.petmily.domain.member.Member;
import org.petmily.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao implements BasicDao {

    private MemberMapper mapper;

    public MemberDao() {
    }

    @Autowired
    public MemberDao(MemberMapper mapper) {
        this.mapper = mapper;
    }

    // 테스트용 메소드
    public Member findOne() {
        Member member = mapper.selectOne();
        return member;
    }

    // BasicDao 메소드
    @Override
    public Member findByPk(long pk) {
        return mapper.selectByPk(pk);
    }

    @Override
    public void insert(DomainObj obj) {
        mapper.insert((Member) obj);
    }

    @Override
    public void update(DomainObj obj) {
        Member member = (Member) obj;
        mapper.update(member);
    }

    @Override
    public void delete(long pk) {
        mapper.delete(pk);
    }

    public long findPk(String id, String pw) {
        return mapper.selectmNumber(id, pw);
    }

    public Member selectMemberById(String id) {
        return mapper.selectMemberById(id);
    }
}
