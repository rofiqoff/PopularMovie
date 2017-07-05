package apps.popularmovie.rofiqoff.com.popularmovie.model;

import java.util.List;

/**
 * Created by rofiqoff on 7/4/17.
 */

public class ReviewModel {

    String id;
    String page;
    List<ReviewData> results;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<ReviewData> getResults() {
        return results;
    }

    public void setResults(List<ReviewData> results) {
        this.results = results;
    }

    public static class ReviewData {
        private String id;
        private String author;
        private String content;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
