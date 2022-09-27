package com.mermer.rxjava.util;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class DelayEx2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("start::" +LocalDateTime.now());
		
		Observable.just(1, 3, 4, 5)
			.doOnNext(data -> System.out.println("data::" + data))
			.delay(item -> {
				Thread.sleep(1000L);
				return Observable.just(item);
			})
			.subscribe(data -> System.out.println(LocalDateTime.now() + " subdata::" + data))
			;
		
		Thread.sleep(5000L);
		
	}

}
