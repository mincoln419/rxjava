package com.mermer.rxjava.condition;

import com.mermer.common.CarMaker;
import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class ContainsEx {
	
	public static void main(String[] args) {
		
		Observable.fromArray(SampleData.carMakers)
			.doOnNext(data -> System.out.println("data::" + data))
			.contains(CarMaker.SAMSUNG)
			.subscribe(data -> System.out.println(data));
		
	}

}
