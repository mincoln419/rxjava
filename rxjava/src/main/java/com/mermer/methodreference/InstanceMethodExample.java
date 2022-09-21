package com.mermer.methodreference;

import java.util.function.Function;

import com.mermer.common.Car;

public class InstanceMethodExample {

	public static void main(String[] args) {
		
		Function<Car, String> f1 = car -> car.getCarName();
		String carName1 = f1.apply(new Car("트래버스"));
		System.out.println(carName1);
		
		Function<Car, String> f2 = Car::getCarName;
		String carName2 = f2.apply(new Car("K5"));
		System.out.println(carName2);
		
	}
	
	
}
