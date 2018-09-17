package epitos.com.albumsearch.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import epitos.com.albumsearch.R;
import epitos.com.albumsearch.fragment.AlbumDetailsFragment;
import epitos.com.albumsearch.fragment.SearchAlbumFragment;
import epitos.com.albumsearch.model.Album;
import epitos.com.albumsearch.model.Albummatches;
import epitos.com.albumsearch.model.Results;
import epitos.com.albumsearch.model.RootObject;
import epitos.com.albumsearch.network.Requests;
import epitos.com.albumsearch.utils.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchAlbumFragment.Host {

    private FragmentTransaction ft;
    private Requests requests;
    private Resources resources;
    private Albummatches albummatches;
    private SearchAlbumFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = getResources();

        fragment = new SearchAlbumFragment();

        ft = getSupportFragmentManager().beginTransaction();
        setFragment(fragment);

        requests = ApiUtils.getRequests();
    }

    @Override
    public void setQuery(String query) {
        requests.getSearchResults("album.search", query, resources.getString(R.string.last_fm_api_key), "json").enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                if (response.isSuccessful()) {
                    RootObject rootObject = response.body();
                    Results results = rootObject.getResults();
                    albummatches = results.getAlbummatches();
                    fragment.setAdapter();
              }
            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {
            }
        });
    }

    @Override
    public ArrayList<Album> getAlbums() {
        return albummatches.getAlbums();
    }

    public void getAlbumDetails(String artistName, String albumName) {
        requests.getAlbumDetails("album.getinfo", resources.getString(R.string.last_fm_api_key),
                artistName, albumName, "json").enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                if (response.isSuccessful()) {
                    RootObject rootObject = response.body();
                    Album album = rootObject.getAlbum();
                    setFragment(AlbumDetailsFragment.newInstance(album));
                }
            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {
            }
        });
    }

    private void setFragment(Fragment fragment) {
        ft.replace(R.id.container, fragment).commit();
    }
}
