package org.petmily.domain.member;

import lombok.Getter;
import org.petmily.domain.DomainObj;

import java.sql.Date;

@Getter
public class Member implements DomainObj {

    private long mNumber;
    private String id;
    private String pw;
    private String name;
    private Date birth;
    private String gender;
    private String email;
    private String phone;
    private String grade;

    public Member() {
    }

    public Member(long mNumber, String id, String pw, String name, Date birth, String gender, String email, String phone, String grade) {
        this.mNumber = mNumber;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.grade = grade;
    }

    public Member(String id, String pw, String name, Date birth, String gender, String email, String phone) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public Member(long mNumber, String pw, String name, String phone, String email) {
        this.mNumber = mNumber;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public boolean matchPw(String pwd) {
        return pw.equals(pwd);
    }
}
