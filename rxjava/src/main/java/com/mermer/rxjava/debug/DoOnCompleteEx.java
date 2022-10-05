package com.mermer.rxjava.debug;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;

import io.reactivex.Observable;

public class DoOnCompleteEx {

	public static void main(String[] args) {
		Observable.range(1, 10)
			.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# 생산자: 데이터 통지 완료"))
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data),
			error -> Logger.log(LogType.ON_ERROR, error),
			() ->Logger.log(LogType.ON_COMPLETE)
			);
	}
}
