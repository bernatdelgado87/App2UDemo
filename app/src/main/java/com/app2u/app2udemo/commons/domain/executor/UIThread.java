package com.app2u.app2udemo.commons.domain.executor;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * MainThread (UI Thread) implementation based on a {@link Scheduler}
 * which will execute actions on the Android UI thread.
 */
public class UIThread implements UIScheduler {

  @Inject
  UIThread() {}

  @Override
  public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }

}
