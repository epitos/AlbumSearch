package epitos.com.albumsearch.network;

import epitos.com.albumsearch.model.RootObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Requests {

    @GET("2.0/")
    Call<RootObject> getSearchResults(@Query("method") String method,
                                      @Query("album") String album,
                                      @Query("api_key") String apiKey,
                                      @Query("format") String format);

    @GET("2.0/")
    Call<RootObject> getAlbumDetails(@Query("method") String method,
                                     @Query("api_key") String apiKey,
                                     @Query("artist") String artist,
                                     @Query("album") String album,
                                     @Query("format") String format);
}
