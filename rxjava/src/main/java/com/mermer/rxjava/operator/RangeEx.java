package com.mermer.rxjava.operator;

import io.reactivex.Observable;

public class RangeEx {

	public static void main(String[] args) throws InterruptedException {
		Observable.range(0, 5).subscribe(num -> System.out.println("data::" + num));
		
		Thread.sleep(3000L);
	}
}
