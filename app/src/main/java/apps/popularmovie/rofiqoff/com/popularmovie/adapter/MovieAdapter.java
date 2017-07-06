package apps.popularmovie.rofiqoff.com.popularmovie.adapter;

import android.app.Activity;
import android.content.Intent;
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
import apps.popularmovie.rofiqoff.com.popularmovie.activity.DetailActivity;
import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieDetailModel;
import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieModel;
import apps.popularmovie.rofiqoff.com.popularmovie.service.APIService;
import apps.popularmovie.rofiqoff.com.popularmovie.utils.ImageUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rofiqoff on 6/18/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    APIService apiService;

    private Activity activity;
    private List<MovieModel.DataMovie> movie;
    private List<MovieDetailModel.GenresData> genres;

    public MovieAdapter(Activity activity, List<MovieModel.DataMovie> movie, List<MovieDetailModel.GenresData> genres) {
        this.activity = activity;
        this.movie = movie;
        this.genres = genres;
    }

    public MovieAdapter(Activity activity, List<MovieModel.DataMovie> movie) {
        this.activity = activity;
        this.movie = movie;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {

        Picasso.with(activity)
                .load(ImageUtils.buildPostUrl(movie.get(position).getPoster_path(), holder.mItemMovieImage.getWidth()))
                .placeholder(R.color.movie_poster_placeholder)
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

        public MovieViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int iPosition = getAdapterPosition();
            String id = String.valueOf(movie.get(iPosition).getId());
            System.out.println("ID : "+id);

            Intent intent = new Intent(activity, DetailActivity.class);
            intent.putExtra("id", id);

            activity.startActivity(intent);
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        }
    }


}
