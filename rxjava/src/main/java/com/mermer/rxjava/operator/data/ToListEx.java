package com.mermer.rxjava.operator.data;

import java.util.List;

import com.mermer.common.SampleData;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ToListEx {

	public static void main(String[] args) {
		
		Single<List<Integer>> single = Observable.just(1,3,5,7,9)
				.toList();
		
		single.subscribe(data -> System.out.println(data));
		
		Observable.fromIterable(SampleData.carList)
		.toList()
		.subscribe(carList -> System.out.println(carList));
		
	}
	
	
}
