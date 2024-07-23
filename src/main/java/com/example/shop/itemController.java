package com.example.shop; //<- 현재 이 파일의 경로.


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller //<-  API를 만들 수 있는 어노테이션
@RequiredArgsConstructor //이거 롬복문법임.
public class itemController {

    private final ItemRepository itemRepository;

    @GetMapping ("/list")
    //@ResponseBody <- 데이터만 보내주고 싶을 때 사용
    public String list(Model model) {
        List<Item> result = itemRepository.findAll();


        model.addAttribute("items", result);
        return "list.html";
    }
}
