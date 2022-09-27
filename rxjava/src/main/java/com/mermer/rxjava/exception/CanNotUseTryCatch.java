package com.mermer.rxjava.exception;

import io.reactivex.Observable;

public class CanNotUseTryCatch {

	
	public static void main(String[] args) {
		
		try {
			Observable.just(2)
			.map(num -> num /0)
			.subscribe(System.out::println);
		}catch(Exception e) {
				System.out.println("오류발생");
		}
		
	}
}
