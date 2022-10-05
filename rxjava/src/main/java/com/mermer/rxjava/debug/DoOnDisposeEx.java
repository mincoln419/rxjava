package com.mermer.rxjava.debug;

import java.util.concurrent.TimeUnit;

import com.mermer.common.CarMaker;
import com.mermer.common.SampleData;
import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;
import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DoOnDisposeEx {
	
	public static void main(String[] args) {
		Observable.fromArray(SampleData.carMakers)
			.zipWith(Observable.interval(300L, TimeUnit.MILLISECONDS), (carMaker, num) -> carMaker)
			.doOnDispose(() -> Logger.log(LogType.DO_ON_DISPOSE, " # 생산자: 구독 해지 완료"))
			.subscribe(new Observer<CarMaker>() {
				private Disposable disposable;
				private long startTime;
				
				@Override
				public void onSubscribe(Disposable d) {
					this.disposable = d;
					this.startTime = TimeUtil.start();
					
				}

				@Override
				public void onNext(CarMaker carMaker) {
					Logger.log(LogType.ON_NEXT, carMaker);
					if(TimeUtil.getCurrentTime() - startTime > 1000L) {
						Logger.log(LogType.PRINT, " # 소비자 : 구독 해지, 1000L 초과");
						disposable.dispose();
					}
				}

				@Override
				public void onError(Throwable e) {
					Logger.log(LogType.ON_ERROR, e);
				}

				@Override
				public void onComplete() {
					Logger.log(LogType.ON_COMPLETE);
				}
			}				
					);
		
		TimeUtil.sleep(2000L);
	}

}
