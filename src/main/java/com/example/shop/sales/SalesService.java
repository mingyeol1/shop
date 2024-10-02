package com.example.shop.sales;

import com.example.shop.Member.CustomUser;
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
//        sales.setMemberId(user.id);

        salesRepository.save(sales);
    }
}
