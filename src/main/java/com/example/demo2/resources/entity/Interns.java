package com.example.demo2.resources.entity;

import com.example.demo2.resources.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "interns")
public class Interns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Column(name = "firstName")
    @Getter @Setter
    private String firstName;

    @Column(name = "lastName")
    @Getter @Setter
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @Getter @Setter
    private Gender gender;

    @Column(name = "DateAndTime")
    @Getter @Setter
    private LocalDateTime localDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    @JsonProperty("details")
    @JsonIgnoreProperties("interns")
    @Getter @Setter
    private InternsDetails internsDetails;

    public Interns() {
    }

    public Interns(String firstName, String lastName, Gender gender, LocalDateTime localDateTime) {
        this(firstName, lastName, gender, localDateTime, null);

    }

    public Interns(String firstName, String lastName, Gender gender, LocalDateTime localDateTime, InternsDetails internsDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.localDateTime = localDateTime;
        this.internsDetails = internsDetails;
    }
}
