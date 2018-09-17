package epitos.com.albumsearch.utils;

import epitos.com.albumsearch.network.Requests;
import epitos.com.albumsearch.network.RetrofitClient;

/**
 * Created by epitos on 20/06/2017.
 */

public class ApiUtils {

    public static Requests getRequests() {
        return new RetrofitClient().getClient().create(Requests.class);
    }
}
