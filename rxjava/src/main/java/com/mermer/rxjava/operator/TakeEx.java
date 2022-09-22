package com.mermer.rxjava.operator;

import java.util.concurrent.TimeUnit;

import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class TakeEx {
	
	public static void main(String[] args) throws InterruptedException {
		
		Observable.fromIterable(SampleData.carList)
			.take(3).subscribe(car -> System.out.println("car::" + car.getCarName()));
		
		System.out.println("=====================");
		
		Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.take(3500L, TimeUnit.MILLISECONDS).subscribe(data -> System.out.println("data::" + data));
		
		
		Thread.sleep(3500L);
	}

}
