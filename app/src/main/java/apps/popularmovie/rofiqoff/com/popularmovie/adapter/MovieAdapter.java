package apps.popularmovie.rofiqoff.com.popularmovie.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import apps.popularmovie.rofiqoff.com.popularmovie.R;
import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieModel;
import apps.popularmovie.rofiqoff.com.popularmovie.utils.ImageUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rofiqoff on 6/18/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private String[] movieData;
    private Activity activity;
    private List<MovieModel.DataMovie> movie;

    public MovieAdapter(Activity activity, List<MovieModel.DataMovie> movie){
        this.activity = activity;
        this.movie = movie;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        Picasso.with(activity)
                .load(ImageUtils.buildPostUrl(movie.get(position).getPoster_path(), holder.mItemMovieImage.getWidth()))
                .into(holder.mItemMovieImage);
        holder.mTitleMovieTextView.setText(movie.get(position).getTitle());

    }

    @Override
    public int getItemCount() {

        return movie.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.img_item_movie) ImageView mItemMovieImage;
        @BindView(R.id.movie_item_title) TextView mTitleMovieTextView;
        @BindView(R.id.movie_item_genres) TextView mGenreMovieTextView;
        @BindView(R.id.movie_item_btn_favorite) ImageButton mButtonFavorite;
        @BindView(R.id.movie_item_container) View container;

        public MovieViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);

            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }



}
