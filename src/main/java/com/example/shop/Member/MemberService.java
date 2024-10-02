package com.example.shop.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public void register(Member member) throws Exception{

        Optional<Member> result = memberRepository.findByUsername(member.username);

        if (result.isPresent()){
            throw new Exception("존재하는 아이디");
        }

        if (member.password.length() < 2 || member.username.length() < 2){
            throw new Exception("8글자 이상");
        }

        String password = passwordEncoder.encode(member.getPassword());

        member.setPassword(password);

        memberRepository.save(member);
    }

}
