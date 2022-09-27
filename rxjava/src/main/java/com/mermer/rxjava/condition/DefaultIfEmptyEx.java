package com.mermer.rxjava.condition;

import io.reactivex.Observable;

public class DefaultIfEmptyEx {
	
	public static void main(String[] args) {
		Observable.just(1,3,4,5,6)
			.filter(num -> num > 10)
			.defaultIfEmpty(10)
			.subscribe(data -> System.out.println(data));
	}

}
