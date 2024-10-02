package com.example.shop.sales;

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

    @PostMapping("/sales")
    public String postSale(Sales sales, Authentication auth){

        salesService.sale(sales,auth);

        return "redirect:/list";
    }

    @GetMapping("/sales/all")
    String getSalesAll(){
        List<Sales> result = salesRepository.findAll();
        System.out.println(result.get(0));
        return "list.html";
    }

}
