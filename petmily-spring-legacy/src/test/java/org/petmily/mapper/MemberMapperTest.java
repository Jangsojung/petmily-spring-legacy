package org.petmily.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.petmily.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class MemberMapperTest {

    @Autowired
    private MemberMapper mapper;

    @Test
    public void test() {
        log.info("mapper = {}", mapper);
        log.info("mapper = {}", mapper.selectOne());
    }

    @Test
    public void test_SelectByPk() {
        Member member = mapper.selectByPk(262);
        log.info("member = {}", member);
    }

    @Test
    public void test_insert() {
        Member insertMember = new Member("good", "good", "insertPlease", Date.valueOf("1999-11-11"), "F", "a@a", "010-101-1111");
        mapper.insert(insertMember);
    }

    @Test
    public void test_update() {
        Member updateMember = new Member(268, "123", "new", "010-1111-1111", "b@b");
        mapper.update(updateMember);
    }

    @Test
    public void test_delete() {
        mapper.delete(268);
    }
}