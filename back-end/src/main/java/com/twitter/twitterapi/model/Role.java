package com.twitter.twitterapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = -559047491361744781L;

    @Id
    @GeneratedValue(generator = "role_generator",strategy = GenerationType.AUTO)
    private long id;

    @Column( nullable = false,columnDefinition = "VARCHAR(50)",unique = true,updatable = false)
    private String authority;

}
