package com.mermer.rxjava.testing;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.mermer.common.Car;
import com.mermer.rxjava.sample.SampleObservable;

import io.reactivex.Observable;

public class BlockingEx {

	@Test
	public void getCarStreamFirstTest() {
		Car car = SampleObservable.getCarStream().blockingFirst();
		String actual = car.getCarName();
		
		assertTrue(actual.equals("말리부"));
	}
	
	
	@Test
	public void getSalesOfBranchAFisrtTest() {
		int actual = SampleObservable.getSalesOfBranchA()
				.take(6)
				.blockingFirst();
		
		assertTrue(actual == 15_000_000);
	}
	
	@Test
	public void getCarSreamLastTest() {
		Car car = SampleObservable.getCarStream().blockingLast();
		String actual = car.getCarName();
		
		assertTrue(actual.equals("SM5"));
	}
	
	
	@Test
	public void getSalesOfBranchALastTest() {
		int actual = SampleObservable.getSalesOfBranchA()
				.take(6)
				.blockingLast();
		assertTrue(actual == 40_000_000);
	}
	

	@Test
	public void getSalesOfBranchASingleTest1() {
		int actual = SampleObservable.getSalesOfBranchA()
				.filter(sale -> sale > 30_000_000)
				.take(1)
				.blockingSingle();
		
		assertTrue(actual == 35_000_000);
	}
	
	
	@Test
	public void getSalesOfBranchASingleTest2() {
		
		assertThrows(IllegalArgumentException.class, () -> {SampleObservable.getSalesOfBranchA()
				.filter(sale -> sale > 30_000_000)
				.take(2)
				.blockingSingle();});
	}
	
	
	@Test
	public void blockingGetTest1() {
		
		assertTrue(Observable.empty().firstElement().blockingGet() == null);
	}
	
	
	@Test
	public void getSalesOfBranchAGetTest1() {
		int actual = SampleObservable.getSalesOfBranchA()
				.reduce((a, b) -> a + b)
				.blockingGet();
		
		assertTrue(actual == 326_000_000);
	}
	
	
	@Test
	public void getSalesOfBranchAGetTest2() {
		int totalSales = Observable.zip(
				SampleObservable.getSalesOfBranchA(),
				SampleObservable.getSalesOfBranchB(),
				SampleObservable.getSalesOfBranchC(),
				(a, b, c) -> a + b + c
			)
			.reduce((a, b) -> a + b)
			.blockingGet();
		
		assertTrue(totalSales == 992_000_000);
	}
}


