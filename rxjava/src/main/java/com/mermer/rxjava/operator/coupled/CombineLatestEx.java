package com.mermer.rxjava.operator.coupled;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class CombineLatestEx {

	public static void main(String[] args) throws InterruptedException {
		Observable<Long> observable1 = Observable.interval(500L, TimeUnit.MILLISECONDS)
				.take(6);
		
		Observable<Long> observable2 = Observable.interval(700L, TimeUnit.MILLISECONDS)
				.take(4)
				.map(num -> num + 1000);
		
		Observable.combineLatest(observable1, observable2, (data1 , data2) -> "data1:" +data1 + " data2:" +data2 )
		.subscribe(data -> System.out.println("data::" + data));
		
		Thread.sleep(4000L);
	}
	
}
