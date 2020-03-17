package com.example.demo2.resources.request;

import com.example.demo2.resources.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class InternRequest {
    @JsonProperty("first_name")
    @Getter
    @Setter
    private String firstName;

    @JsonProperty("last_name")
    @Getter @Setter
    private String lastName;

    @JsonProperty("gender")
    @Getter @Setter
    private Gender gender;
}
