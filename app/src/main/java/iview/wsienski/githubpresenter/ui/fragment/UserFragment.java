package iview.wsienski.githubpresenter.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import iview.wsienski.githubpresenter.R;
import iview.wsienski.githubpresenter.di.compontent.DaggerFragmentCompontent;
import iview.wsienski.githubpresenter.di.compontent.FragmentCompontent;
import iview.wsienski.githubpresenter.ui.activity.MainActivity;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class UserFragment extends Fragment {

    private static final String TAG = UserFragment.class.getSimpleName();
    private FragmentCompontent fragmentCompontent;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_users, container, false);
        fragmentCompontent = DaggerFragmentCompontent.builder()
                .activityComponent(((MainActivity)getActivity()).getActivityCompontent()).build();
        fragmentCompontent.inject(this);
        return view;
    }
}
