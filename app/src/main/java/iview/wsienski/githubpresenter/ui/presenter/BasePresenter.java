package iview.wsienski.githubpresenter.ui.presenter;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();

}
