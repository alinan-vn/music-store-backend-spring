package org.hcl.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name= "name")
    String receiptName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shoppingCart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;
}
