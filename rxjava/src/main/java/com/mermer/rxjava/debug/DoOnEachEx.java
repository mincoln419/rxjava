package com.mermer.rxjava.debug;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;

import io.reactivex.Observable;

public class DoOnEachEx {

public static void main(String[] args) {
	
	int zero = 0;
	Observable.just(1,2,3,4,5,6,7)
	.filter(data -> data > 2)
	.doOnError(error -> Logger.log(LogType.DO_ON_ERROR, "# 생산자: 에러발생" + error.getLocalizedMessage()))
	.doOnSubscribe(disposable -> Logger.log(LogType.DO_ON_SUBSCRIBE, "# 생산자 구독 처리 준비 완료 "))
	.doOnEach(noti -> {
		if(noti.isOnNext()) {
			Logger.log(LogType.DO_ON_EACH, "# 생산자 : 다음");
		}else if(noti.isOnError()) {
			Logger.log(LogType.DO_ON_EACH, "# 생산자 : 오류");
		}else if(noti.isOnComplete()) {
			Logger.log(LogType.DO_ON_EACH, "# 생산자 : 완료");
		}
	})
	.subscribe(data -> Logger.log(LogType.ON_NEXT,data)
			, error -> Logger.log(LogType.ON_ERROR)
			, () -> Logger.log(LogType.ON_COMPLETE) 
			);
	
}
}
