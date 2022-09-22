package com.mermer.rxjava.operator.data;

import io.reactivex.Observable;

public class FlatMapEx {

	public static void main(String[] args) {

		Observable.just("hello")
				.flatMap(hello -> Observable.just("자바", "파이썬", "안드로이드").map(lang -> hello + ", " + lang))
				.subscribe(data -> System.out.println(data));

		Observable.range(2, 1)
				.flatMap(num -> Observable.range(1, 9).map(row -> num + " * " + row + " = " + (row * num)))
				.subscribe(data -> System.out.println(data));
		
		
		System.out.println("=========================");
	
		Observable.range(2, 1)
		.flatMap(num -> Observable.range(1, 9), 
				(sourceData, transData) -> sourceData + " * "  + transData + " = " + sourceData * transData)
		.subscribe(data -> System.out.println(data));
		

	}
}
