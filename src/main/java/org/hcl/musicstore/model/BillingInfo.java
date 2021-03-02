package org.hcl.musicstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BillingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="street_name")
	String streetName;
	
	@Column(name="apartment_number")
	String apartmentNumber;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	@Column(name="credit_card_number")
	int creditCardNumber;
	
	@Column(name="expiration_month")
	int expirationMonth;
	
	@Column(name="expiration_day")
	int expirationDay;
	
	@Column(name="name_on_card")
	String nameOnCard;
	
	@Column(name="pin_number")
	int pinNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
}
