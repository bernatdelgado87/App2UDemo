package com.app2u.app2udemo.commons.domain;

import com.app2u.app2udemo.commons.domain.executor.JobScheduler;
import com.app2u.app2udemo.commons.domain.executor.UIScheduler;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public abstract class Usecase<Observer> {
    private final UIScheduler uiScheduler;
    private final JobScheduler jobScheduler;

    public Usecase(UIScheduler uiScheduler, JobScheduler jobScheduler) {
        this.uiScheduler = uiScheduler;
        this.jobScheduler = jobScheduler;
    }

    public abstract Single<Observer> buildUseCaseObservable();

    public Disposable execute(DisposableSingleObserver<Observer> observer) {
        final Single<Observer> observable = this.buildUseCaseObservable()
                .observeOn(uiScheduler.getScheduler())
                .subscribeOn(jobScheduler.getScheduler());
        return observable.subscribeWith(observer);
    }

}
