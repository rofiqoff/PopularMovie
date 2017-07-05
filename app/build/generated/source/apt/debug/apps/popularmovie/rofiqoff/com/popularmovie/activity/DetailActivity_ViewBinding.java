// Generated code from Butter Knife. Do not modify!
package apps.popularmovie.rofiqoff.com.popularmovie.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import apps.popularmovie.rofiqoff.com.popularmovie.R;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailActivity_ViewBinding implements Unbinder {
  private DetailActivity target;

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target, View source) {
    this.target = target;

    target.mLoadContent = Utils.findRequiredViewAsType(source, R.id.pb_load_detail, "field 'mLoadContent'", ProgressBar.class);
    target.mContentDetailMovie = Utils.findRequiredViewAsType(source, R.id.content_detail_movie, "field 'mContentDetailMovie'", NestedScrollView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar_detail, "field 'toolbar'", Toolbar.class);
    target.mBackdropMovie = Utils.findRequiredViewAsType(source, R.id.image_backdrop_movie, "field 'mBackdropMovie'", ImageView.class);
    target.mPlayVideo = Utils.findRequiredViewAsType(source, R.id.image_button_play, "field 'mPlayVideo'", ImageView.class);
    target.mImageDetail = Utils.findRequiredViewAsType(source, R.id.image_detail, "field 'mImageDetail'", ImageView.class);
    target.mTitle = Utils.findRequiredViewAsType(source, R.id.text_tittle, "field 'mTitle'", TextView.class);
    target.mCountries = Utils.findRequiredViewAsType(source, R.id.text_countries, "field 'mCountries'", TextView.class);
    target.mGenre = Utils.findRequiredViewAsType(source, R.id.text_genre, "field 'mGenre'", TextView.class);
    target.mHomePage = Utils.findRequiredViewAsType(source, R.id.text_home_page, "field 'mHomePage'", TextView.class);
    target.mReleased = Utils.findRequiredViewAsType(source, R.id.text_released, "field 'mReleased'", TextView.class);
    target.mReleasedDate = Utils.findRequiredViewAsType(source, R.id.text_released_date, "field 'mReleasedDate'", TextView.class);
    target.mCompaniesProduction = Utils.findRequiredViewAsType(source, R.id.text_companies_production, "field 'mCompaniesProduction'", TextView.class);
    target.mRatingBarMovie = Utils.findRequiredViewAsType(source, R.id.ratingbar_movie, "field 'mRatingBarMovie'", RatingBar.class);
    target.mOverView = Utils.findRequiredViewAsType(source, R.id.text_overview, "field 'mOverView'", TextView.class);
    target.mReviewText = Utils.findRequiredViewAsType(source, R.id.review_text, "field 'mReviewText'", TextView.class);
    target.mRecyclerviewReview = Utils.findRequiredViewAsType(source, R.id.rv_review, "field 'mRecyclerviewReview'", RecyclerView.class);
    target.mTrailerText = Utils.findRequiredViewAsType(source, R.id.trailer_text, "field 'mTrailerText'", TextView.class);
    target.mRecyclerviewTrailer = Utils.findRequiredViewAsType(source, R.id.rv_trailer, "field 'mRecyclerviewTrailer'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLoadContent = null;
    target.mContentDetailMovie = null;
    target.toolbar = null;
    target.mBackdropMovie = null;
    target.mPlayVideo = null;
    target.mImageDetail = null;
    target.mTitle = null;
    target.mCountries = null;
    target.mGenre = null;
    target.mHomePage = null;
    target.mReleased = null;
    target.mReleasedDate = null;
    target.mCompaniesProduction = null;
    target.mRatingBarMovie = null;
    target.mOverView = null;
    target.mReviewText = null;
    target.mRecyclerviewReview = null;
    target.mTrailerText = null;
    target.mRecyclerviewTrailer = null;
  }
}
