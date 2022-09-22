package com.mermer.rxjava.operator.data;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.mermer.common.Searcher;

import io.reactivex.Observable;

public class SwitchMapEx2 {

	public static void main(String[] args) throws InterruptedException {
		long starttime = System.currentTimeMillis();

		Searcher searcher = new Searcher();

		final List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");
		
		Observable.interval(100L, TimeUnit.MILLISECONDS)
		.take(4)
		.switchMap(data -> {
			String keyword = keywords.get(data.intValue());

			return Observable.just(searcher.search(keyword))
					.doOnNext(notUser -> System.out.println("==========================="))
					.delay(1000L, TimeUnit.MILLISECONDS);
		}).flatMap(resultList -> Observable.fromIterable(resultList))
		.subscribe(data -> System.out.println(data),
					error -> error.printStackTrace(), () -> {
					System.out.println("endtime::" + (System.currentTimeMillis() - starttime));
				});

		Thread.sleep(10000L);

	}

}
