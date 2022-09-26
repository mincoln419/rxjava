package com.mermer.rxjava.operator.coupled;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ConcatEx {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<Long> observable1 = Observable.interval(200L, TimeUnit.MILLISECONDS)
				.take(5);
		
		Observable<Long> observable2 = Observable.interval(400L, TimeUnit.MILLISECONDS)
				.take(5)
				.map(num -> num + 1000);
		
		Observable.concat(observable1, observable2)
		.subscribe(data -> System.out.println("data::" + data));
		
		Thread.sleep(4000L);
		
	}
}
