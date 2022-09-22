package com.mermer.rxjava.operator;

import com.mermer.common.CarMaker;
import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class FilterEx {

	public static void main(String[] args) {
		
		Observable.fromIterable(SampleData.carList)
			.filter(car -> car.getCarMaker()== CarMaker.CHEVROLET)
			.subscribe(car -> System.out.println("car::" + car.getCarName()));
		
		System.out.println("=====================================");
		
		Observable.fromIterable(SampleData.carList)
		.filter(car -> car.getCarMaker()== CarMaker.CHEVROLET)
		.filter(car -> car.getCarPrice() > 30000000)
		.subscribe(car -> System.out.println("car::" + car.getCarName()));
		
	}
}
