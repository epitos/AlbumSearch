package epitos.com.albumsearch.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import epitos.com.albumsearch.R;
import epitos.com.albumsearch.model.Tracks;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder>{

    private Tracks tracks;

    public TracksAdapter(Tracks tracks) {
        this.tracks = tracks;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
