package com.mermer.rxjava.operator.data;

import com.mermer.common.Car;
import com.mermer.common.CarMaker;
import com.mermer.common.SampleData;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class GroupByEx {

	public static void main(String[] args) {
		Observable<GroupedObservable<CarMaker, Car>> observable =
				Observable.fromIterable(SampleData.carList).groupBy(car -> car.getCarMaker());
				
		observable.subscribe(
				groupedObservable -> groupedObservable
				.filter(car -> groupedObservable.getKey().equals(CarMaker.CHEVROLET))
				.subscribe(
						car -> System.out.println(groupedObservable.getKey() + " : " + car.getCarName())
						) 
				);
	}
}
