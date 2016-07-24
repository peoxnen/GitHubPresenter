package iview.wsienski.githubpresenter.di.compontent;

import dagger.Component;
import iview.wsienski.githubpresenter.di.annotations.FragmentScope;
import iview.wsienski.githubpresenter.ui.fragment.UserFragment;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
@FragmentScope
@Component(dependencies = ActivityComponent.class)
public interface FragmentCompontent extends ActivityComponent{
    void inject(UserFragment userFragment);
}
