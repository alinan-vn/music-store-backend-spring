package org.hcl.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(	name = "customer",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    @Column(name="username")
    String username;

    @Column(name="phone")
    String phone;

    @Column(name="password")
    String password;
    
    @Column(name="role")
    private final String role = "user";

}
