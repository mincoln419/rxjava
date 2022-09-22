package com.mermer.rxjava.operator;

import java.util.Arrays;
import java.util.List;

import com.mermer.common.Car;
import com.mermer.common.CarMaker;
import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class DistinctEx {

	
	public static void main(String[] args) {
		Observable.fromArray(SampleData.carMakersDuplicated)
		.distinct()
		.filter(carmaker -> carmaker == CarMaker.SSANGYOUNG)
		.subscribe(car -> System.out.println("car::" + car))
		;
	}
}
 