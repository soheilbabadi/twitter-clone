package com.twitter.twitterapi.reposotory;

import com.twitter.twitterapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUsername(String username);
    Optional<Person> findByEmail(String email);
    Optional<Person> findByPhone(String phone);
    Optional<Person> findByUsernameOrEmailOrPhone(String username,String email,String phone);

}
