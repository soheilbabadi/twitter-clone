package com.twitter.twitterapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor

@Builder
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -3196489863799368249L;

    @Id
    @GeneratedValue(generator = "person_generator",strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false,name = "role_id")
    private long id;

    @Column( nullable = false,columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column( nullable = false,columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(unique = true, nullable = false,columnDefinition = "VARCHAR(50)")
    private String email;

    @JsonIgnore
    private String password;

    @Column(unique = true, nullable = false,columnDefinition = "VARCHAR(15)")
    private String phone;

    @Column(unique = true, nullable = false,columnDefinition = "VARCHAR(50)")
    private String username;

    private LocalDate birthDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_role_junction",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> authorities;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PersonImage> personImages;

    public Person() {
        this.authorities=new HashSet<>();

    }
}

