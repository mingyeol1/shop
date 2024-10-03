package com.example.shop.sales;

import com.example.shop.Member.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;
    private final SalesRepository salesRepository;
    private final MemberRepository memberRepository;

    @PostMapping("/sales")
    public String postSale(Sales sales, Authentication auth){

        salesService.sale(sales,auth);

        return "redirect:/list";
    }

    @GetMapping("/sales/all")
    String getSalesAll(){
//        List<Sales> result = salesRepository.customFindAll();
//        System.out.println(result);

        var result =  memberRepository.findById(1L);
        System.out.println(result.get().getSales());

        return "list.html";
    }

}
