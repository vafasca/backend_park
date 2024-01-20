package com.training.park.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "frecuency_attraction")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Frecuency_attraction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "entryDate")
    private LocalDate entryDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_attraction")
    private Attraction attraction;
}
