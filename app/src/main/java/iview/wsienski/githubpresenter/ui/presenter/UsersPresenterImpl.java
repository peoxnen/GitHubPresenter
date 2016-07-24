package iview.wsienski.githubpresenter.ui.presenter;

import java.util.List;

import javax.inject.Inject;

import iview.wsienski.githubpresenter.data.remote.model.User;
import iview.wsienski.githubpresenter.network.APIService;
import iview.wsienski.githubpresenter.ui.view.UsersView;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class UsersPresenterImpl implements UsersPresenter {

    private UsersView usersView;
    private APIService apiService;
    private Subscription subscription;


    @Inject
    public UsersPresenterImpl(APIService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void loadUsers() {
        Timber.d("loadUsers");
        subscription = apiService.listUsers(15).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        usersView.showProgress(true);
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        usersView.showError("Error download");
                        usersView.showProgress(false);
                    }

                    @Override
                    public void onNext(List<User> users) {
                        usersView.showUserList(users);
                        usersView.showProgress(false);
                    }
                });
    }

    @Override
    public void attachView(UsersView view) {
        this.usersView = view;
    }

    @Override
    public void detachView() {
        if (subscription != null) subscription.unsubscribe();
    }
}
