package com.mermer.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.mermer.common.Car;
import com.mermer.common.CarFilter;
import com.mermer.common.CarMaker;
import com.mermer.common.CarType;

public class LegacyInterfaceExample {

	
	public static void main(String[] args) {
		List<Car> cars = Arrays.asList(
					new Car(CarMaker.HYUNDAE, CarType.SUV, "팰리세이드", 280000000, true),
					new Car(CarMaker.SAMSUNG, CarType.SEDAN, "SM5", 350000000, true),
					new Car(CarMaker.CHEVROLET, CarType.SUV, "트래버스", 500000000, true),
					new Car(CarMaker.KIA, CarType.SEDAN, "K5", 200000000, true),
					new Car(CarMaker.SSANGYOUNG, CarType.SUV, "티볼리", 230000000, true)
				);
				
		Collections.sort(cars, (car1, car2) -> car1.getCarPrice() - car2.getCarPrice());
		
		for(Car car : cars)System.out.println("차이름 :" + car.getCarName() + ", 가격::" + car.getCarPrice());
		
		System.out.println("==================================================");
		List<Car> carsFilterByPrice = CarFilter.filterCarByCustomPredicate(cars, (Car car) -> car.getCarPrice() > 300000000);
		
		for(Car car : carsFilterByPrice)System.out.println("차이름 :" + car.getCarName() + ", 가격::" + car.getCarPrice());
		
		
		System.out.println("==================================================");
		List<Car> carsFilterByCarType = CarFilter.filterCarByCustomPredicate(cars, (Car car) -> car.getCarType().equals(CarType.SUV));
		
		for(Car car : carsFilterByCarType)System.out.println("차이름 :" + car.getCarName() + ", 가격::" + car.getCarPrice());
	}

}
