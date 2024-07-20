package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/") //("")<< 안쪽에 들어가는 건 URL주소임
//    @ResponseBody //<-이게 뭐냐 return 문자를 그대로 보내주라는 뜻임 경로를 쓸거면 이걸 지워야함.
    public String hello() {
        return "index.html"; // <<가능한 이유가 기본 경로가 static이라 가능. 경로만 적어도 보내줄 수 있음.
    }

    @GetMapping("/about") //<- 유저가 /URL로 접속을 하면
    @ResponseBody
    public String about() {
        return "<h1>너무 졸려요<h1>";// <- 이 데이터를 보내줌(출력) // return 문 안에 html 코드를 넣어서 사용 할 수도 있음.

    }
}
