package com.mermer.rxjava;

import java.time.LocalDateTime;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SingleEx {

	//데이터를 1건만 통지하거나 에러를 통지한다
	//완료통지는 하지 않음
	//데이터 개수 요청 필요없음
	//onSuccess = onNext + onComplete
	//클라이언트에 요청에 대응하는 서버의 응답이 Single 사용하기 좋은 예시
	
	public static void main(String[] args) {
	
		Single<String > single = Single.create(new SingleOnSubscribe<String>() {

			@Override
			public void subscribe(SingleEmitter<String> emitter) throws Exception {

				emitter.onSuccess(LocalDateTime.now().toString());
			}
		});
		
		single.subscribe(new SingleObserver<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				//아무것도 하지 않음
			}

			@Override
			public void onSuccess(String data) {
				System.out.println("성공::" + data );
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("실패::" + e);
				
			}
		});
	}
	
}
