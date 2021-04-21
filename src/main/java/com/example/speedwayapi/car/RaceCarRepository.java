package com.example.speedwayapi.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceCarRepository extends JpaRepository<RaceCarEntity, Long> {

    RaceCarEntity findByNickname(String nickname);
}
