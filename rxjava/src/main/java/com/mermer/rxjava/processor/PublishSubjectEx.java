package com.mermer.rxjava.processor;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;

import io.reactivex.subjects.PublishSubject;

public class PublishSubjectEx {

	public static void main(String[] args) {
		
		//전형적인 hot publisher
		
		PublishSubject<Integer> subject = PublishSubject.create();
		
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1 : " + price));
		subject.onNext(3500);
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2 : " + price));
		subject.onNext(3300);
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3 : " + price));
		subject.onNext(3400);
		
		
		subject.subscribe(
					price -> Logger.log(LogType.ON_NEXT, "# 소비자 4 : " + price),
					error -> Logger.log(LogType.ON_ERROR, "# 소비자 4 : " + error),
					() -> Logger.log(LogType.ON_COMPLETE, "")
				);
		
		subject.onComplete();
	}
}
