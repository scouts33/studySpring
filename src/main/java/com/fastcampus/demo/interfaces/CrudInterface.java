package com.fastcampus.demo.interfaces;

import com.fastcampus.demo.model.network.Header;

public interface CrudInterface<Request, Response> {

    Header<Response> create(Header<Request> request);

    Header<Response> show(Long id);

    Header<Response> update(Header<Request> request);

    Header destroy(Long id);
}
