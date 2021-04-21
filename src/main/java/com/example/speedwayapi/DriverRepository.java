package com.example.speedwayapi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DriverRepository extends JpaRepository <DriverEntity,Long > {
}
