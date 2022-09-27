package com.mermer.rxjava.operator.coupled;

import java.util.Arrays;
import java.util.Collections;

import com.mermer.common.SampleData;

import io.reactivex.Observable;

public class ZipEx2 {

	public static void main(String[] args) {
		Observable<Integer> observable1 = Observable.fromIterable(SampleData.seoulPM10List);
		Observable<Integer> observable2 = Observable.fromIterable(SampleData.busanPM10List);
		Observable<Integer> observable3 = Observable.fromIterable(SampleData.incheonPM10List);
		
		Observable<Integer> observable4 = Observable.range(1, 24);
		
		Observable.zip(observable1, observable2, observable3, observable4, (data1, data2, data3, hour) 
				-> hour + "시:" + Collections.max(Arrays.asList(data1, data2, data3)))
		.subscribe(data -> System.out.println(data));
		
		
		
	}
	
}
