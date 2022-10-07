package com.mermer.rxjava.testing;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.mermer.common.Car;
import com.mermer.common.CarMaker;
import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;
import com.mermer.rxjava.sample.SampleObservable;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

public class TestSubscriber {

	
	@Test
	public void testAssertEmpty_fail() {
		
		Observable<Car> observable = SampleObservable.getCarStream();
		TestObserver<Car> observer = observable.test();
		
		//then
		observer.awaitDone(100L,TimeUnit.MILLISECONDS).assertEmpty();
		
		
	}
	
	
	@Test
	public void testAssertEmpty_success() {
		
		Observable<Car> observable = SampleObservable.getCarStream();
		TestObserver<Car> observer = observable.delay(1000L, TimeUnit.MILLISECONDS).test();
		
		//then
		observer.awaitDone(100L,TimeUnit.MILLISECONDS).assertEmpty();

	}


	@Test
	public void testAssertValue() {
		
		Observable.just(1)
			.test()
			.assertValue(1);
		
		
	}
	
	@Test
	public void testAssertValue2() {
		
		SampleObservable.getCarMakerStream()
			.filter(carMaker -> carMaker.equals(CarMaker.SAMSUNG))
			.test()
			.awaitDone(1L, TimeUnit.MILLISECONDS)
			.assertValue(CarMaker.SAMSUNG);
		
	}
	
	
	@Test
	public void testAssertValues() {
		
		SampleObservable.getDuplicateCarMakerStream()
				.filter(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
				.test()
				.awaitDone(1L, TimeUnit.MILLISECONDS)
				.assertValues(CarMaker.CHEVROLET, CarMaker.CHEVROLET);
		
		
	}
	
	
	@Test
	public void testAssertNoValue() {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.filter(data -> data > 5)
			.test()
			.awaitDone(1000L, TimeUnit.MILLISECONDS)
			.assertNoValues();
			
		
		
	}
}
