package com.example.speedwayapi.car;

import lombok.Value;

@Value
public class RaceCarDto {

    String nickname;
    String model;
    String year;
    String owner;
    String status;
    long top_speed;
}
