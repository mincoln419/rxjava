package com.mermer.rxjava.testing;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mermer.common.Car;
import com.mermer.rxjava.sample.SampleObservable;

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
}

