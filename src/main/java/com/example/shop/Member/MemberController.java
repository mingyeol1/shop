package com.example.shop.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/register")
    public String registerGet(){

        return "register.html";
    }

    @PostMapping("/register")
    public String register(Member member){

        memberService.register(member);

        return "redirect:/list";
    }
}
