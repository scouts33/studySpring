package com.fastcampus.demo.model.network;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header {

    private String transactionTime;

    private String resultCode;

    private String description;
}
