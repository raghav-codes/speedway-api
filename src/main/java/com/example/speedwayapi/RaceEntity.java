package com.example.speedwayapi;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;
    private String category;
    private LocalDate date;
    private LocalTime bestTime;
    private String winner;
    private String participants;

    public RaceEntity(String name, String category, LocalDate date, LocalTime bestTime, String winner, String participants) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.bestTime = bestTime;
        this.winner = winner;
        this.participants = participants;
    }

}
