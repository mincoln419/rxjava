package com.mermer.rxjava.debug;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;

import io.reactivex.Observable;

public class DoOnSubscribeEx {

	
	public static void main(String[] args) {
		Observable.just(1,2,3)
			.doOnSubscribe(disposable -> Logger.log(LogType.DO_ON_SUBSCRIBE, "# 생산자 구독 처리 준비 완료 "))
			.subscribe(data -> Logger.log(LogType.ON_NEXT,data)
					, error -> Logger.log(LogType.ON_ERROR)
					, () -> Logger.log(LogType.ON_COMPLETE) 
					);
			
	}
}
