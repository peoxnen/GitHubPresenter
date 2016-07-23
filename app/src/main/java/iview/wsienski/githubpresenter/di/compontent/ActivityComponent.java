package iview.wsienski.githubpresenter.di.compontent;

import dagger.Component;
import iview.wsienski.githubpresenter.di.annotations.ActivityScope;
import iview.wsienski.githubpresenter.ui.activity.MainActivity;

/**
 * Created by Witold Sienski on 23.07.2016.
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent extends AppComponent {

    void inject(MainActivity mainActivity);

}
