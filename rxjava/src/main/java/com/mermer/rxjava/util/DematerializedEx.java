package com.mermer.rxjava.util;

import java.util.Arrays;

import com.mermer.common.util.LogType;
import com.mermer.common.util.Logger;
import com.mermer.common.util.TimeUtil;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DematerializedEx {

    public static void main(String[] args) {
        Observable.concatEager(
                Observable.just(
                        getDBUser().subscribeOn(Schedulers.io()),
                        getAPIUser()
                                .subscribeOn(Schedulers.io())
                                .materialize()
                                .map(notification -> {
                                    if (notification.isOnError()) {
                                        // 관리자에게 에러 발생을 알림
                                        Logger.log(LogType.PRINT, "# API user 에러 발생!");
                                    }
                                    return notification;
                                })
                                .filter(notification -> !notification.isOnError())
                                .dematerialize(notification -> notification)
                )
        ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

        TimeUtil.sleep(1000L);
    }

    private static Observable<String> getDBUser() {
        return Observable.fromIterable(Arrays.asList("DB user1", "DB user2", "DB user3", "DB user4", "DB user5"));
    }

    private static Observable<String> getAPIUser() {
        return Observable
                .just("API user1", "API user2", "Not User", "API user4", "API user5")
                .map(user -> {
                    if(user.equals("Not User"))
                        throw new RuntimeException();
                    return user;
                });
    }
	
}
