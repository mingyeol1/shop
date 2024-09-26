package com.example.shop.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/register")
    public String registerGet(Authentication auth){

        if(auth.isAuthenticated() == true){

            System.out.println("로그인 한 사용자라 list로 리다이렉트");
            return "redirect:/list";
        }

        return "register.html";
    }

    @PostMapping("/register")
    public String register(Member member) throws Exception {



        memberService.register(member);

        return "redirect:/list";
    }


    @GetMapping("/login")
    public String loginGet(){
      return "login.html";
    }

    @GetMapping("/my-page")
    public String mypage(Authentication auth, Principal principal){  //로그인 한 유저 정보 뽑기
//        System.out.println(auth);   //모든 정보 출력
//        System.out.println(auth.getName());     //사용자의 이름 출력 username
//        System.out.println(auth.getAuthorities());  //사용자가 무슨 권한을 가지고 있는지 출력 ex 관리자, 일반유저
//        System.out.println(auth.isAuthenticated()); //현재 로그인 여부 (true, false 있음)

        CustomUser result = (CustomUser) auth.getPrincipal();
        System.out.println(result.displayName);

        return "mypage.html";
    }
}
