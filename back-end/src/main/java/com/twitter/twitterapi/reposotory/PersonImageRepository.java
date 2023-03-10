package com.twitter.twitterapi.reposotory;

import com.twitter.twitterapi.model.PersonImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonImageRepository extends JpaRepository<PersonImage, Long> {

}
