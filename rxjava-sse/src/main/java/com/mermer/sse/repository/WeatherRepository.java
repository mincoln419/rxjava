package com.mermer.sse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mermer.sse.domain.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{
	
}
