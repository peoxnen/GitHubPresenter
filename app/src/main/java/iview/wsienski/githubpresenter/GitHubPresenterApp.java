package iview.wsienski.githubpresenter;

import android.app.Application;

import com.facebook.stetho.Stetho;

import iview.wsienski.githubpresenter.di.compontent.AppComponent;
import iview.wsienski.githubpresenter.di.compontent.DaggerAppComponent;
import iview.wsienski.githubpresenter.di.module.AppModule;
import iview.wsienski.githubpresenter.di.module.NetModule;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 23.07.2016.
 */
public class GitHubPresenterApp extends Application {

    private final static String TAG = GitHubPresenterApp.class.getSimpleName();
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
            Timber.plant(new Timber.DebugTree());
        }

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(getString(R.string.base_url)))
                .build();
        appComponent.inject(this);
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

}
