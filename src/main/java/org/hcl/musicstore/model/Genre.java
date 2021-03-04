package org.hcl.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name= "genre_name")
    String genreName;

    @Column(name="image")
    String image;
}
