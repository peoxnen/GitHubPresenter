package iview.wsienski.githubpresenter.network;

import java.util.List;

import iview.wsienski.githubpresenter.data.remote.model.User;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Witold Sienski on 23.07.2016.
 */
public interface APIService {

    @GET("users")
    Observable<List<User>> listUsers(@Query("since") int since);
}
