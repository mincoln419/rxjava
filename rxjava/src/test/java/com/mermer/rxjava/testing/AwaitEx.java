package com.mermer.rxjava.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;

import io.reactivex.Observable;

public class AwaitEx {
	
	@Test
	public void awaitDone_test() {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.take(5)
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
			.doOnError(err -> Logger.log(LogType.DO_ON_ERROR, err.getLocalizedMessage()))
			.test()
			.awaitDone(500L, TimeUnit.MILLISECONDS)
			.assertNotComplete()
			.assertValueCount(2);
			
	}
	
	
	
	@Test
	public void awaitDone_test2() {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.take(5)
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
			.doOnError(err -> Logger.log(LogType.DO_ON_ERROR, err.getLocalizedMessage()))
			.test()
			.awaitDone(1500L, TimeUnit.MILLISECONDS)
			.assertComplete()
			.assertValueCount(5);
			
	}
	
	@Test
	public void await_test() throws InterruptedException {
		
		Observable.interval(200L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.take(5)
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
			.doOnError(err -> Logger.log(LogType.DO_ON_ERROR, err.getLocalizedMessage()))
			.test()
			.await()
			.assertComplete()
			.assertValueCount(5);
			
	}

	@Test
	public void await_test2() throws InterruptedException {
		
		boolean result = Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.take(5)
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
			.doOnError(err -> Logger.log(LogType.DO_ON_ERROR, err.getLocalizedMessage()))
			.test()
			.await(2000L, TimeUnit.MILLISECONDS);
		
		assertTrue(result == false);
			
	}
	
	@Test
	public void awaitCount_test() throws InterruptedException {
		
		Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.take(5)
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
			.doOnError(err -> Logger.log(LogType.DO_ON_ERROR, err.getLocalizedMessage()))
			.test()
			.awaitCount(3)
			.assertNotComplete()
			.assertValueCount(3)
			.assertValues(0L, 1L, 2L);
			
	}
	
	
	@Test
	public void isTerminated_test() throws InterruptedException {
		
		Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.take(5)
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
			.doOnError(err -> Logger.log(LogType.DO_ON_ERROR, err.getLocalizedMessage()))
			.test()
			.awaitCount(3)
			.assertNotComplete()
			.assertValueCount(3)
			.assertValues(0L, 1L, 2L)
			.isTerminated();
			
	}
	
	@Test
	public void isTerminatedWhenError_test() throws InterruptedException {
		
		Observable.interval(100L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.map(data -> {
				if(data == 4) data = data/0;
				return data;
			})
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
			.doOnError(err -> Logger.log(LogType.DO_ON_ERROR, err.getLocalizedMessage()))
			.test()
			.awaitCount(5)
			.isTerminated();
			
	}
}
