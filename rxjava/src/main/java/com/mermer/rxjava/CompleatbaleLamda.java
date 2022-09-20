package com.mermer.rxjava;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class CompleatbaleLamda {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("thread" + Thread.currentThread());
		Completable completable = Completable.create(emitter -> {
			int sum = 0;
			for(int i = 0 ; i < 100; i++) {
				sum += i;
			}
			System.out.println("thread" + Thread.currentThread());
			System.out.println("합계::" + sum);
			emitter.onComplete();
		});
		
		completable.subscribeOn(Schedulers.computation())
			.subscribe(
					() -> {
						System.out.println("thread" + Thread.currentThread());
						System.out.println("완료");
					},
					error -> System.out.println("실패::" + error) 
		);
		
		Thread.sleep(1000);
	}
	
}
