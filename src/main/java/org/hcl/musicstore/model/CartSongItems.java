package org.hcl.musicstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CartSongItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="quantity")
	int quantity;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "song_id", referencedColumnName = "id")
	private Song song;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "shopping_cart_id", nullable=false)
	private ShoppingCart shoppingCart;
	
}
