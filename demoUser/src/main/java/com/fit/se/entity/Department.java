package com.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "departments")
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String departmentName;

    private String departmentAddress;

    private String departmentCode;

}
