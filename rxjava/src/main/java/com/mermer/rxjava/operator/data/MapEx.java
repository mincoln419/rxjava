package com.mermer.rxjava.operator.data;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class MapEx {

	public static void main(String[] args) {
		
		List<Integer> addList = Arrays.asList(1,3,5,7);
		Observable.fromIterable(addList)
			.map(num -> "1을 더한 결과 " + (num + 1))
			.subscribe(data -> System.out.println(data));
		
		Observable.just("korea", "america", "canada", "paris", "japan", "china")
		.filter(country -> country.length() ==5)
		.map(country -> country.toUpperCase().charAt(0) + country.substring(1))
		.subscribe(data -> System.out.println(data));
		
	}
	
}
