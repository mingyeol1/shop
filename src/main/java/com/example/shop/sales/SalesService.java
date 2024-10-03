package com.example.shop.sales;

import com.example.shop.Member.CustomUser;
import com.example.shop.Member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesRepository salesRepository;

    public void sale(Sales sales, Authentication auth){

        CustomUser user = (CustomUser) auth.getPrincipal();
        System.out.println(user.id);

        var member = new Member(); //ManyToOne로 변경 했으면 그 오브젝트 자체를 불러와야함.
        member.setId(user.id);
        sales.setMember(member);

        salesRepository.save(sales);
    }
}
