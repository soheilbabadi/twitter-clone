package com.twitter.twitterapi.controller;


import com.twitter.twitterapi.model.dto.PersonDto;
import com.twitter.twitterapi.model.dto.PersonImageDto;
import com.twitter.twitterapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personervice;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllperson() {
        List<PersonDto> person = personervice.getAllPersons();
        return ResponseEntity.ok(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable long id) {
        PersonDto person = personervice.getPersonById(id);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto) {
        PersonDto addedPerson = personervice.addPerson(personDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable long id, @RequestBody PersonDto personDto) {
        if (personDto.getId() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            PersonDto updatedPerson = personervice.updatePerson(personDto);
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable long id) {
        personervice.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Void> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {

        var imageDto=new PersonImageDto();
        imageDto.setContentType(file.getContentType());
        imageDto.setPersonId(id);
        imageDto.setFileContent(file.getBytes());
        imageDto.setFileSize(file.getSize());
        imageDto.setFileName(file.getOriginalFilename());

        personervice.addPersonImage(id, imageDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
