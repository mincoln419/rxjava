package com.mermer.rxjava.operator;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class TimerEx {

	public static void main(String[] args) throws InterruptedException {
		Observable<String> timer = Observable.timer(2000, TimeUnit.MILLISECONDS).map(count -> "Do work!");
		
		timer.subscribe(data -> System.out.println("data::" + data));
		
		Thread.sleep(3000L);
	}
}
