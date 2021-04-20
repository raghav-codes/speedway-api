package com.example.speedwayapi;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode

public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String nickName;
    private int wins;
    private int loss;

    public DriverEntity(String firstName, String lastName, int age, String nickName, int wins, int loss) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nickName = nickName;
        this.wins = wins;
        this.loss = loss;
    }
}
