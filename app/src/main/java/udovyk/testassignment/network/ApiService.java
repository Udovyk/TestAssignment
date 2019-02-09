package udovyk.testassignment.network;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import udovyk.testassignment.network.model.UserResponse;

public interface ApiService {

    @GET("?inc=gender,name,nat")
    Observable<Response<UserResponse>> getUsers();

}
