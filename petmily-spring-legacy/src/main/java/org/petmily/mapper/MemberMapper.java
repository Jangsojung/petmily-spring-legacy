package org.petmily.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.petmily.domain.member.Member;

public interface MemberMapper {

    public Member selectOne();

    Member selectByPk(long pk);

    void insert(Member member);

    void update(Member member);

    void delete(long pk);

    long selectmNumber(@Param("id") String id, @Param("pw") String pw);

    Member selectMemberById(String id);
}
