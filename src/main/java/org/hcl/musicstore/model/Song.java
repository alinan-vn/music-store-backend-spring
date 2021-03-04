package org.hcl.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name= "song_name")
    String songName;

    @Column(name = "price")
    float price;

    @Column(name= "image")
    String image;

    @Column(name= "artist")
    String artist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formatType_id", referencedColumnName = "id")
    private FormatType formatType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;




}
