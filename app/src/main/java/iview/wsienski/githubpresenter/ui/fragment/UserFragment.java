package iview.wsienski.githubpresenter.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import iview.wsienski.githubpresenter.R;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class UserFragment extends Fragment {

    private static final String TAG = UserFragment.class.getSimpleName();
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_users, container, false);
        return view;
    }
}
