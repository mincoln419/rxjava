package com.mermer.rxjava.exception;

import io.reactivex.Observable;

public class OnErrorReturn {
	public static void main(String[] args) {

		Observable.just(2)
		.map(num -> num /0)
		.onErrorReturn(exception -> {
			System.out.println("오류발생");
			return -1;
		})
		.subscribe(data -> System.out.println("DATA::" + data));
	
		
	}
}
