package org.petmily.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
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
public class MemberDaoTest {

    @Autowired
    MemberDao memberDao;

    private Member insertMember;

    @Before
    public void before() {
        insertMember = new Member("good", "good", "insertPlease", Date.valueOf("1999-11-11"), "F", "a@a", "010-101-1111");
    }

    @Test
    public void test() {
        Member one = memberDao.findOne();
        System.out.println("one = " + one);
    }

    @Test
    public void test_selectmNumber() {
        long mNumber = memberDao.findPk("xxx", "123");
        System.out.println("mNumber = " + mNumber);
    }

    @Test
    public void test_SelectByPk() {
        Member member = memberDao.findByPk(262);
        log.info("member = {}", member);
    }

    @Test
    public void test_CRUD() {
        memberDao.insert(insertMember);
        long mNumber = memberDao.findPk("good", "good");
        memberDao.update(new Member(mNumber, "good", "updatePlease", "010-1111-1111", "b@b"));
        memberDao.delete(mNumber);
    }
}