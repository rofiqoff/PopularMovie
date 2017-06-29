package apps.popularmovie.rofiqoff.com.popularmovie.service;

import apps.popularmovie.rofiqoff.com.popularmovie.model.MovieModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by rofiqoff on 6/21/17.
 */

public interface APIService {

    String API_KEY = "0ae4468ac9e27e1c733ab56f3f875064";

    String MOVIE_URL = "http://api.themoviedb.org/3/movie/";

    @GET("popular?api_key="+API_KEY)
    Call<MovieModel> getPopularMovie();

    @GET("top_rated?api_key="+API_KEY)
    Call<MovieModel> getTopRatedMovie();

    class Factory{
        public static APIService create(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MOVIE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(APIService.class);

        }
    }

}
