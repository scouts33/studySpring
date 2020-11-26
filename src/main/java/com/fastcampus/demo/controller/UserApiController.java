package com.fastcampus.demo.controller;


import com.fastcampus.demo.interfaces.CrudInterface;
import com.fastcampus.demo.model.network.Header;
import com.fastcampus.demo.model.network.request.UserApiRequest;
import com.fastcampus.demo.model.network.response.UserApiResponse;
import com.fastcampus.demo.service.UserApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/user")
@RestController
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiService userApiService;


    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header index(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header destroy(@PathVariable(name = "id") Long id) {
        return null;
    }
}
