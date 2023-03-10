package com.twitter.twitterapi.model.dto;

import com.twitter.twitterapi.model.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonImageDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -6851829584980235141L;
    private Long id;

  
    private String fileName;

    private long fileSize;

    private String contentType;



    @Lob
    private byte[] fileContent;
    
  private long personId;

}
