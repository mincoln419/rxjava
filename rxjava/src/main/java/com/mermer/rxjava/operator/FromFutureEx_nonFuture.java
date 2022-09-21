package com.mermer.rxjava.operator;

import com.mermer.common.CarRepairShop;

public class FromFutureEx_nonFuture {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		CarRepairShop shop = new CarRepairShop();

		// 차량 수리비
		int carRepairCost = shop.getCarRepairCostSync(10);
		System.out.println("(1) 차량 수리비 계산이 완료되었습니다");
		System.out.println("차량수리비는" + carRepairCost + " 입니다.");

		// 회사에 병가 신청
		requestSickLeave("20210922-01");

		// 보험 접수
		requestInsurance("35소0969");

		long endTime = System.currentTimeMillis();

		double executeTime = (endTime - startTime) / 1000.0;

		System.out.println();
		System.out.println("처리시간 " + executeTime + " 초");

	}

	private static void requestInsurance(String string) {

		try {
			Thread.sleep(1000);
			System.out.println(" (3) 보험 접수가 완료되었습니다");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void requestSickLeave(String carNumber) {

		try {
			Thread.sleep(1000);
			System.out.println(" (2) 병가 신청이 완료되었습니다");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
