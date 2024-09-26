package com.example.shop.Member;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        DB에서 username을 가진 유저를 찾아와서
//        return new User(유저아이디, 비번, 권한) 해주세요

        Optional<Member> result = memberRepository.findByUsername(username);
        if(result.isEmpty()){   //result가 비어있으면 에러발생.
            throw new UsernameNotFoundException("아이디 없움");
        }
        Member user = result.get();

        List<GrantedAuthority> authorities = new ArrayList<>(); //유저에 권한 설정 어떤권한이 있는지.
        authorities.add(new SimpleGrantedAuthority("일반유저"));    //코드정의일 뿐 메모일 뿐이다. 실질적인 권한은 나중에 코드 짜야함.


        var a = new CustomUser(user.getUsername(), user.getPassword(), authorities);
        a.displayName = user.getDisplayName();

        return a;
    }

}


class CustomUser extends User {

    String displayName;

    public CustomUser(String username,
                      String password,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
