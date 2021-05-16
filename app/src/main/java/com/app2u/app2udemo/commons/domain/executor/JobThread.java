package com.app2u.app2udemo.commons.domain.executor;


import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * JobScheduler implementation based on a {@link Scheduler}
 * which will execute tasks in "an unbounded thread pool".
 */
public class JobThread implements JobScheduler {

    @Inject
    JobThread() {}

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }

}
