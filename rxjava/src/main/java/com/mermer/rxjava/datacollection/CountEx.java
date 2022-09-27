package com.mermer.rxjava.datacollection;

import com.mermer.common.SampleData;
import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;

public class CountEx {

	public static void main(String[] args) {
		Observable.just(1,2,3,4,5,6).count()
		.subscribe(data -> System.out.println(data));
		
		
		Observable<String> observable1 = SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA);

		Observable<String> observable2 = SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB);

		Observable<String> observable3 = SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC);

		Observable.concat(observable1, observable2, observable3).count()
			.subscribe(data -> System.out.println("data::" + data));

		TimeUtil.sleep(4000L);

	}
}
