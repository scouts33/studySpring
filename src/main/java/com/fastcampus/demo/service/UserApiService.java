package com.fastcampus.demo.service;

import com.fastcampus.demo.interfaces.CrudInterface;
import com.fastcampus.demo.model.entity.User;
import com.fastcampus.demo.model.network.Header;
import com.fastcampus.demo.model.network.request.UserApiRequest;
import com.fastcampus.demo.model.network.response.UserApiResponse;
import com.fastcampus.demo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        return null;
    }

    @Override
    public Header<UserApiResponse> show(Long id) {

        return userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnRegisteredAt());
            return user;
        })
                .map(user -> userRepository.save(user))
                .map(user -> response(user))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header destroy(Long id) {
        Optional<User> optional = userRepository.findById(id);

        optional.map(user -> {
            userRepository.delete(user);

            return Header.Ok();
        }).orElseGet(()->Header.ERROR("데이터 없음"));

        return null;
    }

    private Header<UserApiResponse> response(User user) {
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unRegisteredAt(user.getUnregisteredAt())
                .build();

        return Header.Ok(userApiResponse);
    }
}
