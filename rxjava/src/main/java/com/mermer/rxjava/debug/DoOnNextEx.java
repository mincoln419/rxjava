package com.mermer.rxjava.debug;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;

import io.reactivex.Observable;

public class DoOnNextEx {

	public static void main(String[] args) {
		
		Observable.just(1,2,3,4,5,6,7)
		.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# 1 " + data))
		.filter(data -> data > 2)
		.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# 2 " + data))
		.doOnSubscribe(disposable -> Logger.log(LogType.DO_ON_SUBSCRIBE, "# 생산자 구독 처리 준비 완료 "))
		.subscribe(data -> Logger.log(LogType.ON_NEXT,data)
				, error -> Logger.log(LogType.ON_ERROR)
				, () -> Logger.log(LogType.ON_COMPLETE) 
				);
		
	}
}
