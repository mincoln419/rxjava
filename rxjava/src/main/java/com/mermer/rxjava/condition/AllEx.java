package com.mermer.rxjava.condition;

import com.mermer.common.CarMaker;
import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class AllEx {

	public static void main(String[] args) {
		Observable.just(1,3,5,7,9,11,12,13)
			.all(num -> num%2 != 0)
			.subscribe(data -> System.out.println(data));
		
		
		Observable.fromIterable(SampleData.carList)
			.doOnNext(data -> System.out.println())
			.map(car -> car.getCarMaker())
			.all(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
			.subscribe(data -> System.out.println(data));
			
	}
}
