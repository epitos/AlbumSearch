package epitos.com.albumsearch.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import epitos.com.albumsearch.R;
import epitos.com.albumsearch.adapter.TracksAdapter;
import epitos.com.albumsearch.model.Album;
import epitos.com.albumsearch.model.Tracks;

public class AlbumDetailsFragment extends Fragment {

    private static final String ALBUM_KEY = "ALBUM_KEY";

    private ImageView albumCoverImageView;
    private TextView albumNameTextView;
    private TextView artistNameTextView;
    private RecyclerView trackListRecyclerView;

    public static AlbumDetailsFragment newInstance(Parcelable album) {
        AlbumDetailsFragment fragment = new AlbumDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ALBUM_KEY, album);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_album_details, container, false);
        bindViews(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Album album = getArguments().getParcelable(ALBUM_KEY);
        albumNameTextView.setText(album.getName());
        artistNameTextView.setText(album.getArtist());
        Picasso.get().load(album.getImage().get(1).getText()).into(albumCoverImageView);

        setRecyclerView(album.getTracks());
    }

    private void bindViews(View v) {
        albumCoverImageView = (ImageView) v.findViewById(R.id.album_cover_id);
        albumNameTextView = (TextView) v.findViewById(R.id.album_name_id);
        artistNameTextView = (TextView) v.findViewById(R.id.artist_name_id);
        trackListRecyclerView = (RecyclerView) v.findViewById(R.id.tracks_list_id);
    }

    private void setRecyclerView(Tracks tracks) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        trackListRecyclerView.setLayoutManager(linearLayoutManager);
        trackListRecyclerView.setHasFixedSize(true);
        trackListRecyclerView.setAdapter(new TracksAdapter(tracks));
    }
}
