package com.mermer.rxjava.exception;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class RetryEx {

	public static void main(String[] args) throws InterruptedException {
		Observable.just(5)
			.flatMap(
					num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
								.map(i -> {
									long result;
									try {
										result = num/i;
									}catch(Exception e) {
										System.out.println("error::" + e.getLocalizedMessage());
										throw e;
									}
									return result;
								}).retry(5)
								.onErrorReturn(throwable -> -1L)
					).subscribe(
							data -> System.out.println("data::" + data),
							error -> System.out.println(error.getLocalizedMessage()),
							() -> System.out.println("완료")
							);
		
		Thread.sleep(5000L);
	}
}
