package com.mermer.rxjava;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CompletableEx {

	//데이터 생산자이지만 데이터를 1건도 통지하지 않고 완료 에러를 통지한다
	
	//데이터 통지 역할 대신 해당 처리가 끝났음을 통지하는 역할
	
	public static void main(String[] args) {
		
		System.out.println("thread" + Thread.currentThread());
		Completable completable = Completable.create(new CompletableOnSubscribe() {
			
			@Override
			public void subscribe(CompletableEmitter emitter) throws Exception {
				int sum = 0;
				for(int i = 0 ; i < 100; i++) {
					sum += i;
				}
				System.out.println("thread" + Thread.currentThread());
				System.out.println("합계::" + sum);
				emitter.onComplete();
			}
		});
		
		completable.subscribeOn(Schedulers.computation())
			.subscribe(new CompletableObserver() {
			
			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(Throwable e) {

				System.out.println("실패::" + e);	
			}
			
			@Override
			public void onComplete() {
				System.out.println("thread" + Thread.currentThread());
				System.out.println("완료");
			}
		});
	}
}
