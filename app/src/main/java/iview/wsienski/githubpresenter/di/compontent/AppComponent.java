package iview.wsienski.githubpresenter.di.compontent;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import iview.wsienski.githubpresenter.GitHubPresenterApp;
import iview.wsienski.githubpresenter.di.module.AppModule;
import iview.wsienski.githubpresenter.di.module.NetModule;
import iview.wsienski.githubpresenter.network.APIService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Witold Sienski on 23.07.2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(GitHubPresenterApp gitHubPresenterApp);

    APIService apiService();
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();

}
