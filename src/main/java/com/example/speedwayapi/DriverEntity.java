package com.example.speedwayapi;

import com.example.speedwayapi.car.RaceCarEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter

public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver_id")
    Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String nickName;

    @OneToMany(
            mappedBy = "driver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<RaceCarEntity> cars;

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

    public void setCars(List<RaceCarEntity> cars) {
        this.cars = cars;
    }
}
