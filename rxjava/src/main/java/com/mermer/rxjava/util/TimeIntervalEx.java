package com.mermer.rxjava.util;

import java.util.Random;

import io.reactivex.Observable;

public class TimeIntervalEx {

	public static void main(String[] args) {
		
		Observable.just(1,3,5,7,9)
			.delay(item -> {
				Random ran = new Random();
				Thread.sleep(ran.nextInt(10000));
				return Observable.just(item);
			})
			.timeInterval()
			.subscribe(
						timed -> System.out.println("통지하는데 걸린 시간:" + timed.time() +" 통지한데이터" + timed.value())
					);
	}
}
