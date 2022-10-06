package com.mermer.rxjava.testing;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.mermer.common.Car;
import com.mermer.common.CarMaker;
import com.mermer.common.util.Calculator;
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
	
	
	@Test
	public void getCarStreamIterableTest() {
		Iterable<CarMaker> iterable = SampleObservable
				.getCarMakerStream()
				.blockingIterable();
		
		Iterator<CarMaker> iterator = iterable.iterator();
		
		assertTrue(iterator.hasNext() == true);
		
		assertTrue(iterator.next().equals(CarMaker.CHEVROLET));
		assertTrue(iterator.next().equals(CarMaker.HYUNDAE));
		assertTrue(iterator.next().equals(CarMaker.SAMSUNG));
		assertTrue(iterator.next().equals(CarMaker.SSANGYOUNG));
		assertTrue(iterator.next().equals(CarMaker.KIA));
		
		
	}
	
	
	@Test
	public void getCarStreamForeachTest() {
		SampleObservable.getSpeedOfSectionA()
			.filter(speed -> speed > 110)
			.blockingForEach(speed -> assertTrue(speed > 110));
		
		
	}
	
	
	@Test
	public void avgtempOfSeoulTest() {
		
		Calculator calculator = new Calculator();
		
		SampleObservable.getSalesOfBranchA()
			.blockingSubscribe(data -> calculator.setSum(data));
		
		assertTrue(calculator.getSum() == 326_000_000);
	}
}


