package com.training.park.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "station")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Station implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "station")
    @JsonManagedReference
    private List<Attraction> attractions = new ArrayList<>();

}
