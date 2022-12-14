package com.mermer.rxjava.operator;

import java.util.concurrent.TimeUnit;

import com.mermer.common.Car;
import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class TakeUntilEx {

	public static void main(String[] args) throws InterruptedException {
		
		Observable.fromIterable(SampleData.carList)
		.takeUntil((Car car) -> car.getCarName().equals("트랙스"))
		.subscribe(car -> System.out.println("car::" + car.getCarName()));
		
		System.out.println("==============================");
		
		
		Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.takeUntil(Observable.timer(5500L, TimeUnit.MILLISECONDS))
			.subscribe(data -> System.out.println("data::" + data));
			
		
			
		Thread.sleep(6000L);
	}
	
}
