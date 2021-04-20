package com.example.speedwayapi.car;

import lombok.Data;
import lombok.Value;

@Value
@Data
public class RaceCarDto {

    String nickname;
    String model;
    String year;
    String owner;
    String status;
    long top_speed;
}
