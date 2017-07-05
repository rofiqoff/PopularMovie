package apps.popularmovie.rofiqoff.com.popularmovie.service;

import apps.popularmovie.rofiqoff.com.popularmovie.model.GenreModel;
import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieDetailModel;
import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieModel;
import apps.popularmovie.rofiqoff.com.popularmovie.model.ReviewModel;
import apps.popularmovie.rofiqoff.com.popularmovie.model.TrailerModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rofiqoff on 6/21/17.
 */

public interface APIService {

    String API_KEY = "0ae4468ac9e27e1c733ab56f3f875064";
    String MOVIE_URL = "http://api.themoviedb.org/3/movie/";

    @GET("popular?api_key=" + API_KEY)
    Call<MovieModel> getPopularMovie();

    @GET("top_rated?api_key=" + API_KEY)
    Call<MovieModel> getTopRatedMovie();

    @GET("genre/movie/list?api_key=" + API_KEY)
    Call<GenreModel> getGenreList();

    @GET("{movie_id}?api_key=" + API_KEY)
    Call<MovieDetailModel> getDetailMovie(@Path("movie_id") Integer movie_id);

    @GET("{movie_id}?api_key=" + API_KEY)
    Call<MovieDetailModel.ProductionCountriesData> getCountries(@Path("movie_id") Integer movie_id);

    @GET("{movie_id}/reviews?api_key=" + API_KEY)
    Call<ReviewModel> getReview(@Path("movie_id") Integer movie_id);

    @GET("{movie_id}/videos?api_key=" + API_KEY)
    Call<TrailerModel> getVideoTrailer(@Path("movie_id") Integer movie_id);

    class Factory {
        public static APIService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MOVIE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(APIService.class);

        }
    }

}
