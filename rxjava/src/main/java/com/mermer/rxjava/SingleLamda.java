package com.mermer.rxjava;

import java.time.LocalDateTime;

import io.reactivex.Single;

public class SingleLamda {

	public static void main(String[] args) {
		
		Single<String> single = Single.create(emitter -> emitter.onSuccess(LocalDateTime.now().toString()));
		
		single.subscribe(
				data -> System.out.println("성공::" + data),
				error -> System.out.println("실패::" + error)
				);
	}
}
