package com.app2u.app2udemo.commons.view.viewmodel;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class CommonViewModel extends ViewModel {
    private final CompositeDisposable disposables = new CompositeDisposable();

    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    public void destroy() {
        disposables.clear();
    }
}
