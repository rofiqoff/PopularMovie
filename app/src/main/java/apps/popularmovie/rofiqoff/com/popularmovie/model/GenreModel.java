package apps.popularmovie.rofiqoff.com.popularmovie.model;

import java.util.ArrayList;

/**
 * Created by rofiqoff on 6/30/17.
 */

public class GenreModel {

    private ArrayList<Genre> genres;

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public static class Genre {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
