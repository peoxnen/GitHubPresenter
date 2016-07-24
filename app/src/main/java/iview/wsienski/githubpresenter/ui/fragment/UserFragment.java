package iview.wsienski.githubpresenter.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import iview.wsienski.githubpresenter.R;
import iview.wsienski.githubpresenter.data.remote.model.User;
import iview.wsienski.githubpresenter.di.compontent.DaggerFragmentCompontent;
import iview.wsienski.githubpresenter.di.compontent.FragmentCompontent;
import iview.wsienski.githubpresenter.ui.activity.MainActivity;
import iview.wsienski.githubpresenter.ui.presenter.UsersPresenterImpl;
import iview.wsienski.githubpresenter.ui.view.UsersView;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class UserFragment extends Fragment implements UsersView{

    private static final String TAG = UserFragment.class.getSimpleName();
    @Inject
    UsersPresenterImpl usersPresenter;
    private FragmentCompontent fragmentCompontent;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_users, container, false);
        fragmentCompontent = DaggerFragmentCompontent.builder()
                .activityComponent(((MainActivity)getActivity()).getActivityCompontent()).build();
        fragmentCompontent.inject(this);
        usersPresenter.attachView(this);
        usersPresenter.loadUsers();
        return view;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showUserList(List<User> userList) {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), "message "+message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        usersPresenter.detachView();
    }

}
