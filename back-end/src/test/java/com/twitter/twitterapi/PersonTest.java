package com.twitter.twitterapi;

import com.twitter.twitterapi.model.Person;
import com.twitter.twitterapi.model.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("password")
                .phone("123-456-7890")
                .username("jdoe")
                .birthDate(LocalDate.of(1990, 1, 1))
                .authorities(Collections.singleton(Role.builder()
                        .authority("ROLE_USER")
                        .build()))
                .build();
    }

    @Test
    @DisplayName("Test person getters")
    void testGetters() {
        Assertions.assertEquals("John", person.getFirstName());
        Assertions.assertEquals("Doe", person.getLastName());
        Assertions.assertEquals("john.doe@example.com", person.getEmail());
        Assertions.assertEquals("password", person.getPassword());
        Assertions.assertEquals("123-456-7890", person.getPhone());
        Assertions.assertEquals("jdoe", person.getUsername());
        Assertions.assertEquals(LocalDate.of(1990, 1, 1), person.getBirthDate());
        Assertions.assertEquals(Collections.singleton(Role.builder()
                .authority("ROLE_USER")
                .build()), person.getAuthorities());
    }

    @Test
    @DisplayName("Test person setters")
    void testSetters() {
        person.setFirstName("Jane");
        Assertions.assertEquals("Jane", person.getFirstName());

        person.setLastName("Doe");
        Assertions.assertEquals("Doe", person.getLastName());

        person.setEmail("jane.doe@example.com");
        Assertions.assertEquals("jane.doe@example.com", person.getEmail());

        person.setPassword("new_password");
        Assertions.assertEquals("new_password", person.getPassword());

        person.setPhone("987-654-3210");
        Assertions.assertEquals("987-654-3210", person.getPhone());

        person.setUsername("janeDoe");
        Assertions.assertEquals("janeDoe", person.getUsername());

        person.setBirthDate(LocalDate.of(1992, 2, 2));
        Assertions.assertEquals(LocalDate.of(1992, 2, 2), person.getBirthDate());

        person.setAuthorities(Collections.singleton(Role.builder()
                .authority("ROLE_ADMIN")
                .build()));
        Assertions.assertEquals(Collections.singleton(Role.builder()
                .authority("ROLE_ADMIN")
                .build()), person.getAuthorities());
    }
}
