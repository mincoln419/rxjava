package com.mermer.rxjava.operator;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class FromIterableEx {

	public static void main(String[] args) {
		
		List<String> countries = Arrays.asList("Korea", "Japan", "China");
		
		Observable.fromIterable(countries).subscribe(c -> System.out.println(c));
	}
}
