package udovyk.testassignment.network;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import udovyk.testassignment.network.model.UserResponse;

public interface ApiService {

    @GET("./")
    Observable<Response<UserResponse>> getUsers(@Query("page") int page, @Query("results") int results);

}
