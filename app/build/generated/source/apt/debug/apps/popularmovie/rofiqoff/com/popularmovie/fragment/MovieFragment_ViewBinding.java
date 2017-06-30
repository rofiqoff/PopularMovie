// Generated code from Butter Knife. Do not modify!
package apps.popularmovie.rofiqoff.com.popularmovie.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import apps.popularmovie.rofiqoff.com.popularmovie.R;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieFragment_ViewBinding implements Unbinder {
  private MovieFragment target;

  @UiThread
  public MovieFragment_ViewBinding(MovieFragment target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_movie, "field 'mRecyclerView'", RecyclerView.class);
    target.mProgresBar = Utils.findRequiredViewAsType(source, R.id.pb_load_movie, "field 'mProgresBar'", ProgressBar.class);
    target.mErrorLayout = Utils.findRequiredViewAsType(source, R.id.layout_connection_error, "field 'mErrorLayout'", RelativeLayout.class);
    target.mRefresh = Utils.findRequiredViewAsType(source, R.id.swipe_refresh_item, "field 'mRefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mProgresBar = null;
    target.mErrorLayout = null;
    target.mRefresh = null;
  }
}
