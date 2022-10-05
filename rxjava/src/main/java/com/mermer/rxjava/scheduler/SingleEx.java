package com.mermer.rxjava.scheduler;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;
import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SingleEx {
	public static void main(String[] args) {
		
		Observable<String> observable = Observable.just("1","2","3","4","5");
		
		observable.subscribeOn(Schedulers.single())
			.map(data -> "##" + data + "##")
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
		
		
		observable.subscribeOn(Schedulers.single())
		.map(data -> "$$" + data + "$$")
		.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
		
		TimeUtil.sleep(1000L);
			
	}
}
