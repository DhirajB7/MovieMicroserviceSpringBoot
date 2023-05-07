package com.dhirajb7.moviecatalogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCatalogEntity {

    private String name;
    private String desc;
    private int rating;

}
