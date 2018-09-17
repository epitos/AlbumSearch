package epitos.com.albumsearch.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import epitos.com.albumsearch.R;
import epitos.com.albumsearch.adapter.AlbumResultsAdapter;
import epitos.com.albumsearch.model.Album;


public class SearchAlbumFragment extends Fragment implements View.OnClickListener {

    public Host host;
    private Button searchButton;
    private EditText queryEditText;
    private RecyclerView recyclerView;
    private AlbumResultsAdapter albumResultsAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        host = (Host) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search_album, container, false);
        bindViews(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListener();
        setRecyclerView();
    }

    @Override
    public void onClick(View v) {
        host.setQuery(queryEditText.getText().toString());
    }

    private void bindViews(View v) {
        searchButton = (Button) v.findViewById(R.id.search_button_id);
        queryEditText = (EditText) v.findViewById(R.id.search_text_id);
        recyclerView = (RecyclerView) v.findViewById(R.id.search_results_id);
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void setListener() {
        searchButton.setOnClickListener(this);
    }

    public void setAdapter() {
        albumResultsAdapter = new AlbumResultsAdapter(getActivity(), host.getAlbums());
        recyclerView.setAdapter(albumResultsAdapter);
    }

    public interface Host {
         void setQuery(String query);
         ArrayList<Album> getAlbums();
    }
}
