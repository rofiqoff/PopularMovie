package apps.popularmovie.rofiqoff.com.popularmovie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import apps.popularmovie.rofiqoff.com.popularmovie.R;
import apps.popularmovie.rofiqoff.com.popularmovie.adapter.ReviewAdapter;
import apps.popularmovie.rofiqoff.com.popularmovie.adapter.TrailerAdapter;
import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieDetailModel;
import apps.popularmovie.rofiqoff.com.popularmovie.model.ReviewModel;
import apps.popularmovie.rofiqoff.com.popularmovie.model.TrailerModel;
import apps.popularmovie.rofiqoff.com.popularmovie.service.APIService;
import apps.popularmovie.rofiqoff.com.popularmovie.utils.ImageUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.layout_error) RelativeLayout mErrorLayout;
    @BindView(R.id.content_detail_movie) NestedScrollView mContentDetailMovie;
    @BindView(R.id.toolbar_detail) Toolbar toolbar;
    @BindView(R.id.image_backdrop_movie) ImageView mBackdropMovie;
    @BindView(R.id.image_button_play) ImageView mPlayVideo;
    @BindView(R.id.image_detail) ImageView mImageDetail;
    @BindView(R.id.text_tittle) TextView mTitle;
    @BindView(R.id.text_countries) TextView mCountries;
    @BindView(R.id.text_genre) TextView mGenre;
    @BindView(R.id.text_home_page) TextView mHomePage;
    @BindView(R.id.text_released) TextView mReleased;
    @BindView(R.id.text_released_date) TextView mReleasedDate;
    @BindView(R.id.text_companies_production) TextView mCompaniesProduction;
    @BindView(R.id.ratingbar_movie) RatingBar mRatingBarMovie;
    @BindView(R.id.text_overview) TextView mOverView;
    @BindView(R.id.review_text) TextView mReviewText;
    @BindView(R.id.rv_review) RecyclerView mRecyclerviewReview;
    @BindView(R.id.trailer_text) TextView mTrailerText;
    @BindView(R.id.rv_trailer) RecyclerView mRecyclerviewTrailer;

    APIService apiService;
    ReviewAdapter mAdapterReview;
    TrailerAdapter mAdapterTrailer;
    ArrayList<ReviewModel.ReviewData> reviews = new ArrayList<>();
    ArrayList<TrailerModel.TrailerData> trailers = new ArrayList<>();
    ArrayList<MovieDetailModel.ProductionCountriesData> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        apiService = APIService.Factory.create();

        LinearLayoutManager layoutManagerReview = new LinearLayoutManager(DetailActivity.this);
        mRecyclerviewReview.setLayoutManager(layoutManagerReview);
        mRecyclerviewReview.setHasFixedSize(true);
        mAdapterReview = new ReviewAdapter(DetailActivity.this, reviews);
        mRecyclerviewReview.setAdapter(mAdapterReview);

        LinearLayoutManager layoutManagerTrailer = new LinearLayoutManager(DetailActivity.this);
        mRecyclerviewTrailer.setLayoutManager(layoutManagerTrailer);
        mRecyclerviewTrailer.setHasFixedSize(true);
        mAdapterTrailer = new TrailerAdapter(DetailActivity.this, trailers);
        mRecyclerviewTrailer.setAdapter(mAdapterTrailer);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));
        System.out.println("ID detail : " + id);

        loadDetailMovie(id);
        loadReviews(id);
        loadTrailers(id);
    }

    public void loadDetailMovie(final int movie_id) {
        mErrorLayout.setVisibility(View.GONE);
        mContentDetailMovie.setVisibility(View.GONE);

        Call<MovieDetailModel> getDetailMovie = apiService.getDetailMovie(movie_id);
        getDetailMovie.enqueue(new Callback<MovieDetailModel>() {
            @Override
            public void onResponse(Call<MovieDetailModel> call, final Response<MovieDetailModel> response) {

                mErrorLayout.setVisibility(View.GONE);
                mContentDetailMovie.setVisibility(View.VISIBLE);

                Picasso.with(DetailActivity.this)
                        .load(ImageUtils.buildPostUrl(response.body().getBackdrop_path(), mBackdropMovie.getWidth()))
                        .placeholder(R.color.movie_poster_placeholder)
                        .into(mBackdropMovie);

                if (response.body().getVideo() == "false") {
                    mPlayVideo.setVisibility(View.GONE);
                } else if (response.body().getVideo() == "true") {
                    mPlayVideo.setVisibility(View.VISIBLE);
                }

                Picasso.with(DetailActivity.this)
                        .load(ImageUtils.buildPostUrl(response.body().getPoster_path(), mImageDetail.getWidth()))
                        .placeholder(R.color.movie_poster_placeholder)
                        .into(mImageDetail);

                mTitle.setText(response.body().getOriginal_title());

//                List<MovieDetailModel.ProductionCountriesData> countries = new ArrayList<>(response.body().getProduction_countries());
//                String[] countriesName = new String[countries.size()];
//                for (int i = 0; i <= countries.size(); i++){
//                    countriesName[i] =
//                            countries.
//                                    get(i).
//                                    getName();
//                    mCountries.setText(countries.get(i+1).getName());
//                }

//                List<MovieDetailModel.GenresData> genres = new ArrayList<>(response.body().getGenres());
//                String[] genresName = new String[genres.size()];
//                for (int j = 0; j <= genres.size(); j ++){
//                    genresName[j] = genres.get(j).getName();
//                }
//                mGenre.setText(genresName.toString());

                mHomePage.setText(response.body().getHomepage());
                mReleased.setText(response.body().getStatus());
                mReleasedDate.setText(response.body().getRelease_date());

//                List<MovieDetailModel.ProductionCompanyData> companies = new ArrayList<>(response.body().getProduction_companies());
//                String companiesName[] = new String[companies.size()];
//                for (int k = 0; k <= companies.size(); k++){
//                    companiesName[k] = companies.get(k).getName();
//                }
//                mCompaniesProduction.setText(companiesName.toString());

                mReviewText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mRecyclerviewReview.getVisibility() == View.GONE) {
                            mRecyclerviewReview.setVisibility(View.VISIBLE);
                        } else if (mRecyclerviewReview.getVisibility() == View.VISIBLE) {
                            mRecyclerviewReview.setVisibility(View.GONE);
                        }
                    }
                });

                mTrailerText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mRecyclerviewTrailer.getVisibility() == View.GONE){
                            mRecyclerviewTrailer.setVisibility(View.VISIBLE);
                        } else if (mRecyclerviewTrailer.getVisibility() == View.VISIBLE){
                            mRecyclerviewTrailer.setVisibility(View.GONE);
                        }
                    }
                });

                mRatingBarMovie.setRating(Float.parseFloat(response.body().getVote_average()));
                mOverView.setText(response.body().getOverview());

            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
                mErrorLayout.setVisibility(View.VISIBLE);
                mContentDetailMovie.setVisibility(View.GONE);
            }
        });
    }

    private void loadReviews(int movie_id) {
        Call<ReviewModel> getReview = apiService.getReview(movie_id);
        getReview.enqueue(new Callback<ReviewModel>() {
            @Override
            public void onResponse(Call<ReviewModel> call, Response<ReviewModel> response) {
                reviews = new ArrayList<>(response.body().getResults());
                mAdapterReview = new ReviewAdapter(DetailActivity.this, reviews);
                mRecyclerviewReview.setAdapter(mAdapterReview);
            }

            @Override
            public void onFailure(Call<ReviewModel> call, Throwable t) {

            }
        });
    }

    private void loadTrailers(int movie_id) {
        Call<TrailerModel> getTrailer = apiService.getVideoTrailer(movie_id);
        getTrailer.enqueue(new Callback<TrailerModel>() {
            @Override
            public void onResponse(Call<TrailerModel> call, Response<TrailerModel> response) {
                trailers = new ArrayList<>(response.body().getResults());
                mAdapterTrailer = new TrailerAdapter(DetailActivity.this, trailers);
                mRecyclerviewTrailer.setAdapter(mAdapterTrailer);
            }

            @Override
            public void onFailure(Call<TrailerModel> call, Throwable t) {

            }
        });
    }
}
