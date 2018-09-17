package epitos.com.albumsearch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import epitos.com.albumsearch.R;
import epitos.com.albumsearch.activity.MainActivity;
import epitos.com.albumsearch.model.Album;

public class AlbumResultsAdapter extends RecyclerView.Adapter<AlbumResultsAdapter.ViewHolder> {

    private static final int IMAGE_INDEX_POSITION = 2;

    private ArrayList<Album> albums;
    private Context context;

    public AlbumResultsAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.album_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.artistNameTextView.setText(album.getArtist());
        holder.albumNameTextView.setText(album.getName());

        if (!album.getImage().get(IMAGE_INDEX_POSITION).getText().isEmpty()) {
            Picasso.get().load(album.getImage().get(IMAGE_INDEX_POSITION).getText()).into(holder.albumCoverImageView);
        }

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).getAlbumDetails(
                        holder.artistNameTextView.getText().toString(),
                        holder.albumNameTextView.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView artistNameTextView;
        public TextView albumNameTextView;
        public ImageView albumCoverImageView;
        public RelativeLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);

            artistNameTextView = (TextView) itemView.findViewById(R.id.artist_name_id);
            albumNameTextView = (TextView) itemView.findViewById(R.id.album_name_id);
            albumCoverImageView = (ImageView) itemView.findViewById(R.id.album_cover_id);
            layout = (RelativeLayout) itemView.findViewById(R.id.item_layout);
        }
    }
}
