package com.mermer.rxjava.operator.coupled;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class CombineLatestEx2 {

	public static void main(String[] args) throws InterruptedException {
		
		Random random = new Random();
		Observable<Integer> observable1 = Observable.interval(random.nextInt(500), TimeUnit.MILLISECONDS)
				.take(10)
				.map(notUse -> SampleData.temperatureOfSeoul[random.nextInt(5)]);
		
		Observable<Integer> observable2 = Observable.interval(random.nextInt(500), TimeUnit.MILLISECONDS)
				.take(10)
				.map(notUse -> SampleData.humidityOfSeoul[random.nextInt(5)]);
		
		Observable.combineLatest(observable1, observable2, (data1 , data2) -> "최신온도:" +data1 + " 최신습도:" +data2 )
		.subscribe(data -> System.out.println("data::" + data));
		
		Thread.sleep(4000L);
	}
	
}
