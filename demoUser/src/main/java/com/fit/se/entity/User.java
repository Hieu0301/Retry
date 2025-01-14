package com.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    private Department department;

}
