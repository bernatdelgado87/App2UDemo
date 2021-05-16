package com.app2u.app2udemo.commons.domain.executor;

import io.reactivex.Scheduler;

/**
 * Thread abstraction created to change the execution context from
 * job thread(data) to UI thread(main).
 */
public interface UIScheduler {
    Scheduler getScheduler();
}
