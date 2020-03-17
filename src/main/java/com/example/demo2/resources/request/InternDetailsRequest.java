package com.example.demo2.resources.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class InternDetailsRequest {

    @JsonProperty("intern_id")
    @Getter
    private Long id;

    @JsonProperty("address")
    @Getter
    private String address;

    @JsonProperty("zip_code")
    @Getter
    private Long zipCode;

    public InternDetailsRequest(Long id, String address, Long zipCode) {
        this.id = id;
        this.address = address;
        this.zipCode = zipCode;
    }


}
