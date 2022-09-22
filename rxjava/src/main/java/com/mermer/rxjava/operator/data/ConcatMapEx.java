package com.mermer.rxjava.operator.data;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ConcatMapEx {

	public static void main(String[] args) throws InterruptedException {
		long starttime = System.currentTimeMillis();
		Observable.interval(100L,TimeUnit.MILLISECONDS)
		.take(4)
		.skip(2)
		.concatMap(num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
				.take(10)
				.skip(1)
				.map(row -> num + " * " + row + " = " + (num * row))
				).subscribe(data -> System.out.println(data)
						, error -> error.printStackTrace()
						, () -> {
							System.out.println("endtime::" + (System.currentTimeMillis() -starttime));
						}
						);
		
		
		Thread.sleep(5000L);
		
		
	}
	
}
