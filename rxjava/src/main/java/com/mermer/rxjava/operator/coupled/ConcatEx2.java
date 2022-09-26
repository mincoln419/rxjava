package com.mermer.rxjava.operator.coupled;

import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class ConcatEx2 {
	public static void main(String[] args) throws InterruptedException {

		Observable<String> observable1 = SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA);

		Observable<String> observable2 = SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB);

		Observable<String> observable3 = SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC);

		Observable.concat(observable1, observable2, observable3)
			.subscribe(data -> System.out.println("data::" + data));

		Thread.sleep(4000L);

	}
}
