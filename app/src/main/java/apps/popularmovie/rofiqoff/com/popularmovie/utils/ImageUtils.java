package apps.popularmovie.rofiqoff.com.popularmovie.utils;

/**
 * Created by rofiqoff on 6/20/17.
 */

public class ImageUtils {

    public static final String BASE_URL = "http://image.tmdb.org/t/p/";

    public static String buildPostUrl(String imagaPath, int width){
        String widthPath;

        if (width <= 92){
            widthPath = "/w92";
        } else if (width <= 154){
            widthPath = "/w154";
        } else if (width <= 185){
            widthPath = "/w185";
        } else if (width <= 324){
            widthPath = "/w324";
        } else if (width <= 500){
            widthPath = "/500";
        } else {
            widthPath = "/w780";
        }

        return BASE_URL + widthPath + imagaPath;

    }

}
