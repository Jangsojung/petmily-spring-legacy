package org.petmily.controller;

import lombok.extern.slf4j.Slf4j;
import org.petmily.dao.MemberDao;
import org.petmily.domain.member.Member;
import org.petmily.domain.member.form.JoinRequest;
import org.petmily.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class MemberController {

    @Autowired MemberService memberService;
    @Autowired MemberDao memberDao;

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String joinForm() {
        return "/login/joinForm";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(@ModelAttribute("joinRequest") JoinRequest joinRequest) {
        log.info("넘어온 joinRequest : {}", joinRequest);

        if (!joinRequest.isPwEqualToConfirm()) {
            return "login/joinForm";
        }

        memberService.join(joinRequest);

        return "/login/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "/login/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("id") String id,
            @RequestParam("pw") String pw,
            HttpServletRequest request) {

        Member authUser = memberService.login(id, pw);

        if (authUser == null) {
            return "/login/loginForm";
        }

        request.getSession().setAttribute("authUser", authUser);

        return "/main/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();

        return "/main/index";
    }
}
