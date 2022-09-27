package com.mermer.rxjava.datacollection;

import io.reactivex.Observable;

public class ReduceEx {

	
	public static void main(String[] args) {
		Observable.just(1,2,3,4,5,6).reduce((num1, num2) -> {
			System.out.println("num1:" + num1 + " num2:" + num2);
			return num1 + num2;
		})
		.subscribe(data -> System.out.println(data));
		
		Observable.just(1,2,3,4,5,6).scan((num1, num2) -> {
			return num1 + num2;
		})
		.subscribe(data -> System.out.println(data));
		
		System.out.println("========================");
		Observable.range(1, 10)
			.sorted((o1, o2) -> o2 - o1)
			.reduce((num1, num2) -> num1 - num2)
			.subscribe(data -> System.out.println(data));
	}
}
