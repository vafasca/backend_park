package com.training.park.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "attraction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Attraction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", length = 50)
    private String description;
    @Column(name = "classification", length = 50)
    private String classification;
    @Column(name = "useCondition", length = 50)
    private String useCondition;
}
