package com.example.speedwayapi.car;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class RaceCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String nickname;
    String model;
    String year;
    String owner;
    String status;
    long top_speed;

    public RaceCarEntity(String nickname, String model, String year, String owner, String status, long top_speed) {
        this.nickname = nickname;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.status = status;
        this.top_speed = top_speed;
    }
}
