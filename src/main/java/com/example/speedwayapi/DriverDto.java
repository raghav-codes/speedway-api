package com.example.speedwayapi;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class DriverDto {

    private String firstName;
    private String lastName;
    private int age;
    private String nickName;
    private int wins;
    private int loss;

    public DriverDto(String firstName, String lastName, int age, String nickName, int wins, int loss) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nickName = nickName;
        this.wins = wins;
        this.loss = loss;
    }
}
