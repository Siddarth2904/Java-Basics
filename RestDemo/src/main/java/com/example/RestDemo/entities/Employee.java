package com.example.RestDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name",length = 100,nullable = false)
    private String name;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "gender", columnDefinition = "CHAR(1)")
    private Character gender;

    @Column(name="age")
    private Integer age;
}
