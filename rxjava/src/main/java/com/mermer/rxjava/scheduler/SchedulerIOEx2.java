package com.mermer.rxjava.scheduler;

import java.io.File;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;
import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerIOEx2 {

	public static void main(String[] args) {
		
		File[] files = new File("src/main/java/com/mermer/rxjava/").listFiles();
		
		Observable.fromArray(files)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data.getName()))
			.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.computation())
			.filter(data -> data.isDirectory())
			.map(dir -> dir.getName())
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
			
		TimeUtil.sleep(1000L);
			
	}
}
