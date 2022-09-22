package com.mermer.rxjava.operator.data;

import java.util.Map;

import com.mermer.common.SampleData;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ToMapEx {

	public static void main(String[] args) {
		
		Single<Map<String, String>> single = 
				Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
				.toMap(data -> data.split("-")[0]);
		
		single.subscribe(map -> System.out.println(map));
		
		
		Single<Map<String, String>> single2 = 
				Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
				.toMap(data -> data.split("-")[0],
						data -> data.split("-")[1]
						);
		
		single2.subscribe(map -> System.out.println(map));
		
		
		Observable.fromIterable(SampleData.carList)
		.toMap(data -> data.getCarName(),
				data -> data.getCarMaker()
				).subscribe(data -> System.out.println(data));
		
		 
		
		
	}
}
