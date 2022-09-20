package com.mermer.rxjava;

import java.time.LocalDateTime;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MaybeEx {

	//데이터를 1건만 통지하거나 1건도 통지하지 않고 완료 또는 에러를 통지한다.
	
	//데이터 통지 자체가 완료를 의미하기 때문에 완료는 통지하지 않는다
	
	public static void main(String[] args) {
		
		
		Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>() {

			@Override
			public void subscribe(MaybeEmitter<String> emitter) throws Exception {
				emitter.onSuccess(LocalDateTime.now().toString());
				emitter.onComplete();
			}
		});
		
		maybe.subscribe(new MaybeObserver<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String t) {
				System.out.println("성공::" + t);
				 
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("실패::" + e);	
				
			}

			@Override
			public void onComplete() {
				System.out.println("완료");
				
			}
			
		});
		
	}
	
}
