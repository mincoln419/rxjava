package com.mermer.rxjava;

import java.time.LocalDateTime;

import io.reactivex.Maybe;

public class MaybeLamda {

	
	public static void main(String[] args) {
		
		Maybe<String> maybe = Maybe.create(emitter -> {
			emitter.onSuccess(LocalDateTime.now().toString());
		});
		
		maybe.subscribe(
					data -> System.out.println("성공::" + data),
					error -> System.out.println("실패::" + error),
					() -> System.out.println("완료")
				);
		
	}
}
