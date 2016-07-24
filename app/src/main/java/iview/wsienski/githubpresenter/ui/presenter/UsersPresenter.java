package iview.wsienski.githubpresenter.ui.presenter;

import iview.wsienski.githubpresenter.ui.view.UsersView;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public interface UsersPresenter extends BasePresenter<UsersView>{
  void loadUsers();
}
