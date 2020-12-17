package com.meli.topSecret.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class satellitesDTO {

    private String name;
    private Float distance;
    private List<String> message;

}
