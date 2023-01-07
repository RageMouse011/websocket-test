package com.ragemouse.listofcities.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "cities_id_seq",
            allocationSize = 1
    )
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="population")
    private int population;
    @Column(name="area")
    private double area;
}
