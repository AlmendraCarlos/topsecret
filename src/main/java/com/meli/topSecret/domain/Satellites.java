package com.meli.topSecret.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ElementCollection;
import javax.persistence.Id;
import java.util.List;

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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ElementCollection
    private List<String> message;

}
