package com.mermer.rxjava.condition;

import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SequenceEqualEx {
	
	public static void main(String[] args) {
		Observable observable1 =   Observable.just(1,2,3,4,5,6)
				.subscribeOn(Schedulers.computation())
				.delay(num -> {
								TimeUtil.sleep(100L);
								return Observable.just(num);
						});
		
		Observable observable2 =   Observable.just(1,2,3,4,5,6);
			Observable.sequenceEqual(observable1, observable2)
			.subscribe(data -> System.out.println(data));
			;
		
			
			TimeUtil.sleep(1000L);
	}

}
