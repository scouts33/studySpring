package com.fastcampus.demo.repository;

import com.fastcampus.demo.DemoApplicationTests;
import com.fastcampus.demo.model.entity.Item;
import com.fastcampus.demo.model.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemRepositoryTest extends DemoApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        Item item = new Item();

        item.setName("노트북");
        item.setPrice(10000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);

        Assertions.assertNotNull(newItem);
    }
}
