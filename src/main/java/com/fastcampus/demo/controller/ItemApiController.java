package com.fastcampus.demo.controller;


import com.fastcampus.demo.interfaces.CrudInterface;
import com.fastcampus.demo.model.network.Header;
import com.fastcampus.demo.model.network.request.ItemApiRequest;
import com.fastcampus.demo.model.network.response.ItemApiResponse;
import com.fastcampus.demo.service.ItemApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiService itemApiService;

    @Override
    @PostMapping("")
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        return itemApiService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> show(@PathVariable Long id) {
        return itemApiService.show(id);
    }

    @Override
    @PutMapping("")
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        return itemApiService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header destroy(@PathVariable Long id) {
        return itemApiService.destroy(id);
    }
}
