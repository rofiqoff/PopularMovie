// Generated code from Butter Knife. Do not modify!
package apps.popularmovie.rofiqoff.com.popularmovie.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import apps.popularmovie.rofiqoff.com.popularmovie.R;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieAdapter$MovieViewHolder_ViewBinding implements Unbinder {
  private MovieAdapter.MovieViewHolder target;

  @UiThread
  public MovieAdapter$MovieViewHolder_ViewBinding(MovieAdapter.MovieViewHolder target,
      View source) {
    this.target = target;

    target.mItemMovieImage = Utils.findRequiredViewAsType(source, R.id.img_item_movie, "field 'mItemMovieImage'", ImageView.class);
    target.mTitleMovieTextView = Utils.findRequiredViewAsType(source, R.id.movie_item_title, "field 'mTitleMovieTextView'", TextView.class);
    target.mGenreMovieTextView = Utils.findRequiredViewAsType(source, R.id.movie_item_genres, "field 'mGenreMovieTextView'", TextView.class);
    target.mButtonFavorite = Utils.findRequiredViewAsType(source, R.id.movie_item_btn_favorite, "field 'mButtonFavorite'", ImageButton.class);
    target.container = Utils.findRequiredView(source, R.id.movie_item_container, "field 'container'");
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieAdapter.MovieViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mItemMovieImage = null;
    target.mTitleMovieTextView = null;
    target.mGenreMovieTextView = null;
    target.mButtonFavorite = null;
    target.container = null;
  }
}
