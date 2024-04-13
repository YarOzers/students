package com.yaroslav.students.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.Period;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    @Column(unique = true)
    String email;
    @Transient
    int age;

    public int getAge() {
        return Period.between(dateOfBirth,LocalDate.now()).getYears();
    }
}
