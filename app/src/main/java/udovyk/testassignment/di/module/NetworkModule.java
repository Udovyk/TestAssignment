package udovyk.testassignment.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import udovyk.testassignment.common.Constants;
import udovyk.testassignment.network.ApiManager;
import udovyk.testassignment.network.ApiService;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit) {
        return  retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public ApiManager provideApiManager(ApiService apiService) {
        return new ApiManager(apiService);
    }

}
