package com.app2u.app2udemo.commons.domain.executor;

import io.reactivex.observers.DisposableSingleObserver;

public class Observer<T> extends DisposableSingleObserver<T> {

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

}