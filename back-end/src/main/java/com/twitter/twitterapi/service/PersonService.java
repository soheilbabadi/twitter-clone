package com.twitter.twitterapi.service;

import com.twitter.twitterapi.model.dto.PersonDto;
import com.twitter.twitterapi.model.dto.PersonImageDto;

import java.io.IOException;
import java.util.List;

public interface PersonService {
    List<PersonDto> getAllPersons();

    PersonDto getPersonById(long id);
    PersonDto getPersonByUsername(String username,String password);

    PersonDto addPerson(PersonDto personDto);

    PersonDto updatePerson(PersonDto personDto);

    void deletePerson(long id);
    PersonImageDto addPersonImage(long personId, PersonImageDto personImageDto) throws IOException;
    PersonImageDto getPersonImage(long personId);



}
