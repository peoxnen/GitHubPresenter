package iview.wsienski.githubpresenter.di.module;

import android.app.Fragment;

import dagger.Module;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
@Module
public class FragmentModule {
    final Fragment fragment;

    public FragmentModule(Fragment fragment){
        this.fragment=fragment;
    }
}
