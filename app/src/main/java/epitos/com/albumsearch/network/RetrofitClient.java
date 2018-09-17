package epitos.com.albumsearch.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "http://ws.audioscrobbler.com/";

    private HttpLoggingInterceptor logging;
    private OkHttpClient.Builder httpClient;
    private Retrofit retrofit;

    public RetrofitClient() {
        logging = new HttpLoggingInterceptor();
        httpClient = new OkHttpClient.Builder();

        setLogging();
        setInterceptor();
    }

    public void setLogging() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public void setInterceptor() {
        httpClient.addInterceptor(logging);
    }

    public Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit;
    }
}
