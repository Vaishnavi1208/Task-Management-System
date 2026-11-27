package org.acme.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String username;

    private String password;


    // Constructors
    public Users() {}

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
