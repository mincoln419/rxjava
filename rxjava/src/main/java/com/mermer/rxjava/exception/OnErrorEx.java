package com.mermer.rxjava.exception;

import io.reactivex.Observable;

public class OnErrorEx {

	
	public static void main(String[] args) {
		
		Observable.just(2)
			.map(num -> num /0)
			.subscribe(data -> System.out.println(data),
					error -> System.out.println("error" + error.getLocalizedMessage())
					
					);
		
	}
}
