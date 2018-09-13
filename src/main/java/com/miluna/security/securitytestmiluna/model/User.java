package com.miluna.security.securitytestmiluna.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class User {

    @Id
    Long id;

    String name;

    String password;

}
