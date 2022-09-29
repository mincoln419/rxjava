package com.mermer.rxjava.processor;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectEx {

	public static void main(String[] args) {
		//완료 전까지 아무것도 통지하지 않고 있다가 완료했을 때 마지막으로 통지한 데이터와 완료만 통지
		//완료 후 구독시에도 수령 받음
		ReplaySubject<Integer> subject = ReplaySubject.create();
		
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1 : " + price));
		subject.onNext(3500);
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2 : " + price));
		subject.onNext(3300);
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3 : " + price));
		subject.onNext(3400);
		
		subject.onComplete();
		
		subject.subscribe(
					price -> Logger.log(LogType.ON_NEXT, "# 소비자 4 : " + price),
					error -> Logger.log(LogType.ON_ERROR, "# 소비자 4 : " + error),
					() -> Logger.log(LogType.ON_COMPLETE)
				);
		
	}
}
