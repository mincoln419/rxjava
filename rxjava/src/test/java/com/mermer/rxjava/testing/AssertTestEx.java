package com.mermer.rxjava.testing;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;
import com.mermer.common.util.TimeUtil;
import com.mermer.rxjava.sample.SampleObservable;

import io.reactivex.Observable;

public class AssertTestEx {
	
	@Test
	public void assertResult_test() {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.filter(data -> data > 3)
			.test()
			.awaitDone(1100L, TimeUnit.MILLISECONDS)
			.assertResult(4L);
			
	}

	
	@Test
	public void assertResult_success_test() {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.take(5)
			.filter(data -> data > 3)
			.test()
			.awaitDone(1100L, TimeUnit.MILLISECONDS)
			.assertResult(4L);
			
	}
	
	@Test
	public void assertError_test1() {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.map(data -> {
				long value;
				if(data == 4)
					value = data/ 0;
				else
					value = data/ 2;
				return value;
			})
			.test()
			.awaitDone(1100L, TimeUnit.MILLISECONDS)
			.assertError(Throwable.class)
			;
	}
	
	@Test
	public void assertError_test2() {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.map(data -> {
				long value;
				if(data == 4)
					value = data/ 0;
				else
					value = data/ 2;
				return value;
			})
			.test()
			.awaitDone(1100L, TimeUnit.MILLISECONDS)
			.assertError(e -> e.getClass()== ArithmeticException.class)
			;
	}
	
	
	@Test
	public void assertComplete_test1() {
		
		SampleObservable.getSalesOfBranchA()
			.zipWith(SampleObservable.getSalesOfBranchB(), (a, b) -> {
				TimeUtil.sleep(100L);
				return a + b;
			})
			.test()
			.awaitDone(3000L, TimeUnit.MILLISECONDS)
			.assertComplete();
	}
	
	
	@Test
	public void assertNotComplete_test1() {
		
		SampleObservable.getSalesOfBranchA()
			.zipWith(SampleObservable.getSalesOfBranchB(), (a, b) -> {
				TimeUtil.sleep(1000L);
				return a + b;
			})
			.test()
			.awaitDone(3000L, TimeUnit.MILLISECONDS)
			.assertNotComplete();
	}
}
