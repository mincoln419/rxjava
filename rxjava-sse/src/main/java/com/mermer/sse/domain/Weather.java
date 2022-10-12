package com.mermer.sse.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private long weatherId;
    private int temperature;
    private int humidity;

    public Weather(){}
    public Weather(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
	
}
