package iview.wsienski.githubpresenter.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import iview.wsienski.githubpresenter.R;
import iview.wsienski.githubpresenter.data.remote.model.User;
import iview.wsienski.githubpresenter.di.compontent.DaggerFragmentCompontent;
import iview.wsienski.githubpresenter.di.compontent.FragmentCompontent;
import iview.wsienski.githubpresenter.ui.activity.MainActivity;
import iview.wsienski.githubpresenter.ui.adapter.UserCardAdapter;
import iview.wsienski.githubpresenter.ui.presenter.UsersPresenterImpl;
import iview.wsienski.githubpresenter.ui.view.UsersView;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class UserFragment extends Fragment implements UsersView{

    private static final String TAG = UserFragment.class.getSimpleName();
    @Inject
    UsersPresenterImpl usersPresenter;
    FragmentCompontent fragmentCompontent;
    View view;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    UserCardAdapter userCardAdapter;
    private List<User> users = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_users, container, false);
        ButterKnife.bind(this, view);
        fragmentCompontent = DaggerFragmentCompontent.builder()
                .activityComponent(((MainActivity)getActivity()).getActivityCompontent()).build();
        fragmentCompontent.inject(this);
        usersPresenter.attachView(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        userCardAdapter = new UserCardAdapter(getActivity(), users);
        recyclerView.setAdapter(userCardAdapter);
        usersPresenter.loadUsers();
        return view;
    }

    @Override
    public void showProgress(boolean show) {
        Timber.d("showProgress");
        int visible = show ? View.VISIBLE : View.GONE;
        progressBar.setVisibility(visible);
    }

    @Override
    public void showUserList(List<User> userList) {
        Timber.d("showUserList");
        users.addAll(userList);
        userCardAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Timber.d("showError");
        new MaterialDialog.Builder(getActivity())
                .title(R.string.dialog_aplogize_title)
                .content(message)
                .negativeText(R.string.dialog_button_ok)
                .show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        usersPresenter.detachView();
    }

}
