package com.twitter.twitterapi.service;


import com.twitter.twitterapi.model.Person;
import com.twitter.twitterapi.model.PersonImage;
import com.twitter.twitterapi.model.dto.PersonDto;
import com.twitter.twitterapi.model.dto.PersonImageDto;
import com.twitter.twitterapi.reposotory.PersonImageRepository;
import com.twitter.twitterapi.reposotory.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonImageRepository personImageRepository;

    @Override
    public List<PersonDto> getAllPersons() {
        List<PersonDto> personDtos = new ArrayList<>();
        personRepository.findAll().forEach(person -> {
            PersonDto personDto = new PersonDto();
            BeanUtils.copyProperties(person, personDto);
            personDtos.add(personDto);
        });
        return personDtos;
    }
    @Override
    public PersonDto getPersonById(long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            PersonDto personDto = new PersonDto();
            BeanUtils.copyProperties(personOptional.get(), personDto);
            return personDto;
        } else {
            return null;
        }
    }

    @Override
    public PersonDto getPersonByUsername(String username, String password) {
        Optional<Person> personOptional = personRepository.findByUsernameOrEmailOrPhone(username,username,username)
                .filter(person -> person.getPassword().equals(password));
        if (personOptional.isPresent()) {
            PersonDto personDto = new PersonDto();
            BeanUtils.copyProperties(personOptional.get(), personDto);
            return personDto;
        } else {
            return null;
        }
    }

    @Override
    public PersonDto addPerson(PersonDto personDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        person = personRepository.save(person);
        BeanUtils.copyProperties(person, personDto);
        return personDto;
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getId())
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + personDto.getId()));
        BeanUtils.copyProperties(personDto, person);
        person = personRepository.save(person);
        BeanUtils.copyProperties(person, personDto);
        return personDto;
    }

    @Override
    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonImageDto addPersonImage(long personId, PersonImageDto personImageDto) throws IOException {
        var photo=new PersonImage();
        BeanUtils.copyProperties(personImageDto, photo);


        photo.setPerson(personRepository.getReferenceById(personId));
        photo=personImageRepository.save(photo);
        BeanUtils.copyProperties(photo, personImageDto);
        return personImageDto;
    }

    @Override
    public PersonImageDto getPersonImage(long personId) {
        return null;
    }

}