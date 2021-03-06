package com.meli.topSecret.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Satellites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double pos_x;

    private double pos_y;

    private double distance;

    @ManyToOne
    private Messages message;

}
