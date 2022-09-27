package com.mermer.rxjava.operator.coupled;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ZipEx {
	public static void main(String[] args) throws InterruptedException {
		Observable<Long> observable1 = Observable.interval(200L, TimeUnit.MILLISECONDS)
				.take(4);
		
		Observable<Long> observable2 = Observable.interval(400L, TimeUnit.MILLISECONDS)
				.take(6)
				.map(num -> num + 1000);
		
		Observable.zip(observable1, observable2, (data1 , data2) -> data1 + data2 )
		.subscribe(data -> System.out.println("data::" + data));
		
		Thread.sleep(4000L);
	}
}
