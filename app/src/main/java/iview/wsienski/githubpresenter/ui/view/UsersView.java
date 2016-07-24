package iview.wsienski.githubpresenter.ui.view;

import java.util.List;

import iview.wsienski.githubpresenter.data.remote.model.User;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public interface UsersView {
    void showProgress(boolean show);
    void showUserList(List<User> userList);
    void showError(String message);
}
