package com.mermer.rxjava.operator.data;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class SwitchMapEx {

	
	public static void main(String[] args) throws InterruptedException {
		long starttime = System.currentTimeMillis();
		Observable.interval(1000L,TimeUnit.MILLISECONDS)
		.take(4)
		.skip(2)
		.doOnNext(data -> System.out.println(data))
		.switchMap(num -> Observable.interval(300L, TimeUnit.MILLISECONDS)
				.take(10)
				.skip(1)
				.map(row -> num + " * " + row + " = " + (num * row))
				).subscribe(data -> System.out.println(data)
						, error -> error.printStackTrace()
						, () -> {
							System.out.println("endtime::" + (System.currentTimeMillis() -starttime));
						}
						);
		
		
		Thread.sleep(10000L);
		
		
		
	}
	
}
