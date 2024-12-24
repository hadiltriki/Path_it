package com.praject.pathit.dao.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.praject.pathit.web.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("Comments")//comment
public class Comment {
@Id
    private String id;

    private String texte;
    private LocalDateTime date = LocalDateTime.now();

    @DBRef(lazy = true) // L'utilisateur est chargé uniquement lorsqu'il est nécessaire
    private User auteur;

   /*  @DBRef(lazy = true) // Relation optionnelle avec un bootcamp
    private Bootcamp bootcamp;*/

    /*@DBRef(lazy = true) // Relation optionnelle avec une ressource
    private Ressource ressource;*/
}
