package com.example.speedwayapi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {


    @GetMapping("racecars")
    String getAllRaceCars(){

    return "{}";
    }


}
