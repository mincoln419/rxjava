package com.mermer.rxjava.operator;

import java.time.LocalDateTime;

import io.reactivex.Observable;

public class DeferEx {

	public static void main(String[] args) throws InterruptedException {
		Observable<LocalDateTime> observable = Observable.defer(() -> Observable.just(LocalDateTime.now()));
		
		Observable<LocalDateTime> observablejust = Observable.just(LocalDateTime.now());
		
		observable.subscribe(time -> System.out.println("defer 구독1의 구독시간" + time));
		observablejust.subscribe(time -> System.out.println("just 구독1의 구독시간" + time));
		
		Thread.sleep(3000L);
		
		observable.subscribe(time -> System.out.println("defer 구독2의 구독시간" + time));
		observablejust.subscribe(time -> System.out.println("just 구독2의 구독시간" + time));
		
	}
}
