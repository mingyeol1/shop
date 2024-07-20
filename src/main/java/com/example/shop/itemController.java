package com.example.shop; //<- 현재 이 파일의 경로.


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //<-  API를 만들 수 있는 어노테이션
public class itemController {

    @GetMapping ("/list")
    //@ResponseBody <- 데이터만 보내주고 싶을 때 사용
    public String list(Model model) {
        model.addAttribute("name", "홍길동");
        return "list.html";
    }
}
