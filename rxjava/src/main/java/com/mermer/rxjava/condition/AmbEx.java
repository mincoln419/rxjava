package com.mermer.rxjava.condition;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.mermer.common.SampleData;
import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;

public class AmbEx {

	public static void main(String[] args) {
		Observable<Object> observable1 =  Observable.fromIterable(SampleData.carList)
			.delay(400L, TimeUnit.MILLISECONDS)
			.map(car -> car.getCarMaker());
		
		Observable<Object> observable2 =  Observable.fromIterable(SampleData.carList)
				.delay(600L, TimeUnit.MILLISECONDS)
				.map(car -> car.getCarName());
		
		Observable<Object> observable3 =  Observable.fromIterable(SampleData.carList)
				.delay(300L, TimeUnit.MILLISECONDS)
				.map(car -> String.valueOf(car.getCarPrice()));
		
		List<Observable<Object>> list = Arrays.asList(observable1, observable2, observable3);
		
		
		Observable.amb(list)
		.doOnComplete(() -> System.out.println("완료"))
		.subscribe(data -> System.out.println(data));
		
		TimeUtil.sleep(1000);
	}
	
}
