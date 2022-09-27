package com.mermer.rxjava.util;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class TimeoutEx {

	public static void main(String[] args) {
		
		Observable.range(1, 5)
			.map(num -> {
				long time = 1000L;
				if(num == 4) {
					time = 1500L;
				}
				Thread.sleep(time);
				return num;
			}).timeout(1200L, TimeUnit.MILLISECONDS)
			.subscribe(
						data -> System.out.println("data::" + data)
						, error -> System.out.println("에러:" + error.getLocalizedMessage())
					);
	}
}
