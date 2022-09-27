package com.mermer.rxjava.util;

import io.reactivex.Observable;

public class MaterializeEx {

	public static void main(String[] args) {
		Observable.just(1,2,3,4,5,6)
			.materialize()
			.subscribe(notification -> {
				String notificationTyupe = notification.isOnNext()? "onNext()" : (notification.isOnError() ? "onError()" : "onComplete()");
				System.out.println("notification 타입 : " + notificationTyupe);
				System.out.println("data:" + notification.getValue());
			});
	}
}
