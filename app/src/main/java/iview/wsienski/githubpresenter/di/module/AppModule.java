package iview.wsienski.githubpresenter.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Witold Sienski on 23.07.2016.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication){
        this.mApplication=mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application mApplication){
        return PreferenceManager.getDefaultSharedPreferences(mApplication);
    }
}
