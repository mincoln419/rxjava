package com.mermer.rxjava.exception;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class OnErrorResumeNextEx {

	public static void main(String[] args) throws InterruptedException {
		Observable.just(5L)
		.flatMap(num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
				.take(5)
				.map(i -> num /i)
				.onErrorResumeNext(throwable -> {
					System.out.println("오류발생::" + ((Throwable) throwable).getLocalizedMessage()); 
					return Observable.interval(100L, TimeUnit.MILLISECONDS).take(5);
				})
			)
			.subscribe(data -> System.out.println(data),
			error -> System.out.println("error" + error.getLocalizedMessage())
			);
	
		
		Thread.sleep(2000L);
	}
}
