package com.mermer.rxjava.scheduler;

import java.io.File;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;
import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerNewThreadEx {

	public static void main(String[] args) {
		
		Observable<String> observable = Observable.just("1","2","3","4");
		
		observable.subscribeOn(Schedulers.newThread())
			.map(data -> "##" + data + "##")
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
		
		
		observable.subscribeOn(Schedulers.newThread())
		.map(data -> "$$" + data + "$$")
		.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
		
		TimeUtil.sleep(1000L);
			
	}
}
