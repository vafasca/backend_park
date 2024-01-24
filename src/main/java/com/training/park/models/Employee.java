package com.training.park.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "schedule")
    private String schedule;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private  String password;



    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_rol")
    private Rol rol;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_station")
    private Station station;
}
