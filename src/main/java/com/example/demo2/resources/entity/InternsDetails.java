package com.example.demo2.resources.entity;

import com.example.demo2.resources.entity.Embeddble.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "intern_details")
public class InternsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

   @Embedded
   @Getter @Setter
   private Address address;

    @OneToOne(mappedBy = "internsDetails")
    @JsonIgnoreProperties("details")
    @JsonProperty("interns")
    @Getter @Setter
    private Interns interns;

    public InternsDetails(Address address) {
        this.address = address;
    }

    public InternsDetails() {
    }
}