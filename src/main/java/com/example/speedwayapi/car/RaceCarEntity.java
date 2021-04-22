package com.example.speedwayapi.car;

import com.example.speedwayapi.DriverEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class RaceCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Long id;

    String nickname;
    String model;
    String year;
    String owner;
    String status;
    long top_speed;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private DriverEntity driver;

    public RaceCarEntity(String nickname, String model, String year, String owner, String status, long top_speed) {
        this.nickname = nickname;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.status = status;
        this.top_speed = top_speed;
    }
}
