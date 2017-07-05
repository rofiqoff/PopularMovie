package apps.popularmovie.rofiqoff.com.popularmovie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rofiqoff on 6/21/17.
 */

public class MovieModel {

    private String page;
    private String total_results;
    private String total_pages;
    private List<DataMovie> results;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<DataMovie> getDataMovies() {
        return results;
    }

    public void setDataMovies(List<DataMovie> dataMovies) {
        this.results = dataMovies;
    }

    public static class DataMovie{

        private String vote_count;
        private int id;
        private String video;
        private String vote_average;
        private String title;
        private String popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private ArrayList<String> genre_ids;
        private String backdrop_path;
        private String adult;
        private String overview;
        private String release_date;

        public String getVote_count() {
            return vote_count;
        }

        public void setVote_count(String vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getVote_average() {
            return vote_average;
        }

        public void setVote_average(String vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPopularity() {
            return popularity;
        }

        public void setPopularity(String popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public ArrayList<String> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(ArrayList<String> genre_ids) {
            this.genre_ids = genre_ids;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getAdult() {
            return adult;
        }

        public void setAdult(String adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }
    }
}
