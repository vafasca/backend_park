package com.training.park.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "name")
    private String name;
    @Column(name = "description", length = 50)
    private String description;
    @Column(name = "classification", length = 50)
    private String classification;
    @Column(name = "useCondition", length = 50)
    private String useCondition;
    @Column(name = "machine")
    private Boolean statusMachine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_station")
    @JsonBackReference
    private Station station;

}
