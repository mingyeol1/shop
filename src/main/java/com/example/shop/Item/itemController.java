package com.example.shop.Item; //<- 현재 이 파일의 경로.


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller //<-  API를 만들 수 있는 어노테이션
@RequiredArgsConstructor //이거 롬복문법임.
public class itemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping ("/list")
    //@ResponseBody <- 데이터만 보내주고 싶을 때 사용
    public String list(Model model) {
        List<Item> result = itemRepository.findAll();


        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    public String write() {

        return "write.html";
    }
    @PostMapping("/add")
    public String addPost(@RequestBody Item item) {

        itemRepository.save(item);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){

        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()) {
            Item item = result.get(); // Optional에서 실제 객체를 추출
            model.addAttribute("items", item); // Optional이 아닌 실제 객체를 모델에 추가
        }

        return "detail.html";
    }

    @GetMapping("/modify/{id}")
    String getModify(@PathVariable Long id, Model model){

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            Item item = result.get();


            model.addAttribute("items", item);
        }

        ;

        return "modify.html";
    }

    @PostMapping("/modify/{id}")
    String modify(@PathVariable Long id, Model model, String title, Integer price){

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            Item item = result.get();
            model.addAttribute("items", item);

            item.setTitle(title);
            item.setPrice(price);


            itemRepository.save(item);
        }

        System.out.println("변경했음");

        return "redirect:/list";
    }

    @DeleteMapping("/delete")
    ResponseEntity<String> ajaxTest(@RequestParam Long id){         //유저가 보낸 타입이 무엇인지 모르겠으면  Object로 설정

         itemRepository.deleteById(id);

            return ResponseEntity.status(200).body("삭제완료");
    }


    @GetMapping("/test2")
    String ajaxTest2(@RequestParam Long id){         //유저가 보낸 타입이 무엇인지 모르겠으면  Object로 설정

        var result = new BCryptPasswordEncoder().encode("dd");

        System.out.println(result);

        return "redirect:/list";
    }


    @ExceptionHandler(Exception.class)
    public void handler(){

    }
}
