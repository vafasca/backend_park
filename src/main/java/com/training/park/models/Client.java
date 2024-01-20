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
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "ci", length = 50)
    private String ci;
    @Column(name = "phone",length = 50)
    private String phone;
    @Column(name = "email",length = 50)
    private String email;
    @Column(name = "height",length = 50)
    private Double height;
    @Column(name = "age",length = 50)
    private int age;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "client_id")
    private List<Ticket> tickets = new ArrayList<Ticket>();

    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_promotion")
    private Promotion promotion;
}
