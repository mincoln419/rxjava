package com.mermer.rxjava.operator;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class IntervalEx {

	public static void main(String[] args) throws InterruptedException {
		Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
		.map(num -> num +" count")
		.subscribe(data -> System.out.println("data::" + data));
		
		Thread.sleep(10000L);
	}
	
	
}
