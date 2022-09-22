package com.mermer.rxjava.operator;

import java.util.concurrent.TimeUnit;

import com.mermer.common.Car;
import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class SkipEx {

	public static void main(String[] args) throws InterruptedException {
		
		Observable.fromIterable(SampleData.carList)
		.skip(3)
		.subscribe(car -> System.out.println("car::" + car.getCarName()));
		
		System.out.println("==============================");
		
		
		Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.skip(3500L, TimeUnit.MILLISECONDS)
			.subscribe(data -> System.out.println("data::" + data));
			
		
			
		Thread.sleep(6000L);
		
	}
	
}
