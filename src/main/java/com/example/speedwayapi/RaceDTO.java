package com.example.speedwayapi;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RaceDTO {

    private String name;
    private String category;
    private LocalDate date;
    private LocalTime bestTime;
    private String winner;
    private String participants;

    public RaceDTO(String name, String category, LocalDate date, LocalTime bestTime, String winner, String participants) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.bestTime = bestTime;
        this.winner = winner;
        this.participants = participants;
    }


}
