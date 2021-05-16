package com.app2u.app2udemo.commons.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.di.ApplicationComponent;
import com.app2u.app2udemo.commons.di.DaggerApplication;
import com.app2u.app2udemo.commons.view.fragment.ErrorFullScreenFragment;

public abstract class BaseActivity extends AppCompatActivity {
    private LinearLayout errorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjustFontScale(getResources().getConfiguration());
        initInjection();
        bindViews();
    }

    protected abstract void injectView(ApplicationComponent appComponent);

    @CallSuper
    protected void bindViews() {

    }


    private void initInjection() {
        injectView(((DaggerApplication) getApplication()).getApplicationComponent());
    }

    //prevents giant font size from user configuration
    public void adjustFontScale(Configuration configuration) {
        if (configuration.fontScale > 1.20) {
            configuration.fontScale = 1.20f;
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics(metrics);
            metrics.scaledDensity = configuration.fontScale * metrics.density;
            getBaseContext().getResources().updateConfiguration(configuration, metrics);
        }
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            if (isTaskRoot()) {
                finish();
            } else {
                super.onBackPressed();
            }
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    public void nextFragment(Fragment nextFragment) {
        boolean isRegisterCompletedFragmentDetected = false;
        final FragmentManager fragmentManager = getSupportFragmentManager();
        for (int i = fragmentManager.getBackStackEntryCount() - 1; i >= 0; i--) {
            if (nextFragment.getClass().getSimpleName().equals(fragmentManager.getBackStackEntryAt(i).getName())) {
                isRegisterCompletedFragmentDetected = true;
            }
            // ...
        }
        if (!isRegisterCompletedFragmentDetected) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit, R.anim.fragment_pop_enter, R.anim.fragment_pop_exit)
                    .replace(R.id.process_activity_fragment_container, nextFragment)
                    .addToBackStack(nextFragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    public void showErrorFullScreen() {
        nextFragment(ErrorFullScreenFragment.newInstance());
    }
}
