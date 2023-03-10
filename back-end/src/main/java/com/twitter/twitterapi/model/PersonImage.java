package com.twitter.twitterapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonImage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1576244159418926373L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String fileName;

    private long fileSize;
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String contentType;



    @Lob
    private byte[] fileContent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

}
