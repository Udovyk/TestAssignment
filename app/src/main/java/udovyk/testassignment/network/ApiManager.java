package udovyk.testassignment.network;

import io.reactivex.Observable;
import retrofit2.Response;
import udovyk.testassignment.network.model.UserResponse;

public class ApiManager {

    private ApiService apiService;

    public ApiManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<Response<UserResponse>> getUsers() {
        return apiService.getUsers();
    }
}
