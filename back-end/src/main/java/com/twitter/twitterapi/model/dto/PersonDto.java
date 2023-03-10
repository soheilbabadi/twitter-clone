package com.twitter.twitterapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6617300967308827738L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private LocalDate birthDate;

    // getter and setter methods
}