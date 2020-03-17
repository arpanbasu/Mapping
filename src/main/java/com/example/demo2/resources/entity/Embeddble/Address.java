package com.example.demo2.resources.entity.Embeddble;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "address")
    @Getter @Setter
    private String address;

    @Column(name = "zip_code")
    @Getter @Setter
    private Long zipCode;

    public Address() {
    }

    public Address(String address, Long zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }
}
