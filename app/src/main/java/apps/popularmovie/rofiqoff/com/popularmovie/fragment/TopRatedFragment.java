package apps.popularmovie.rofiqoff.com.popularmovie.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import apps.popularmovie.rofiqoff.com.popularmovie.R;
import apps.popularmovie.rofiqoff.com.popularmovie.adapter.MovieAdapter;
import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieModel;
import apps.popularmovie.rofiqoff.com.popularmovie.service.APIService;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_movie_top_rated) RecyclerView mRecyclerView;
    @BindView(R.id.pb_load_movie) ProgressBar mProgressBar;
    @BindView(R.id.layout_connection_error) RelativeLayout mErrorLayout;
    @BindView(R.id.swipe_refresh_item) SwipeRefreshLayout mRefresh;

    MovieAdapter mAdapter;
    APIService apiService;
    ArrayList<MovieModel.DataMovie> movies = new ArrayList<>();

    public TopRatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_rated, container, false);
        ButterKnife.bind(this, view);

        apiService = APIService.Factory.create();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MovieAdapter(getActivity(), movies);
        mRecyclerView.setAdapter(mAdapter);

        mRefresh.setOnRefreshListener(this);

        loadMovie();

        return view;
    }

    private void loadMovie() {

        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        mErrorLayout.setVisibility(View.GONE);

        Call<MovieModel> listMovie = apiService.getTopRatedMovie();
        listMovie.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                mProgressBar.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                mErrorLayout.setVisibility(View.GONE);

                movies = new ArrayList<>(response.body().getDataMovies());

                mAdapter = new MovieAdapter(getActivity(), movies);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
//                Log.d("Error", t.getMessage());

                mProgressBar.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.GONE);
                mErrorLayout.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onRefresh() {
        loadMovie();

        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        mErrorLayout.setVisibility(View.GONE);
        mRefresh.setRefreshing(false);
    }

    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
