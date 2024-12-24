package com.praject.pathit.dao.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document( collection = "formations")
public class Formation {
  //hadil

    @Id
    private String id; // MongoDB ID (String)

    private String title; // Titre -> title
    private String description;
    private double duration; // Duree -> duration

    private Level level; // Niveau -> level
    private String link;

  /*   @DBRef // Référence au Bootcamp
    private Bootcamp bootcamp;*/

  /*  @DBRef // Référence à la liste des ressources
    private List<Resource> resources;*/

}





