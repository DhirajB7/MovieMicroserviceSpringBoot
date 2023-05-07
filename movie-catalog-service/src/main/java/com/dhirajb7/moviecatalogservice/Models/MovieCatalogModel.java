package com.dhirajb7.moviecatalogservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCatalogModel {

    private String name;
    private String desc;
    private int rating;

}
