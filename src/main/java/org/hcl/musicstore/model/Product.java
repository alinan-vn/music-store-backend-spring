package org.hcl.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    float price;

    @Column(name = "image")
    String image;

    @Column(name = "Description")
    String Description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "condition_id", referencedColumnName = "id")
    private ConditionType conditionType;

}
