package com.example.shop;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(Item item) {

        itemRepository.save(item);
    }


    public void remove(Long id) {

        itemRepository.deleteById(id);
    }
}
