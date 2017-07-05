// Generated code from Butter Knife. Do not modify!
package apps.popularmovie.rofiqoff.com.popularmovie.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import apps.popularmovie.rofiqoff.com.popularmovie.R;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrailerAdapter$TrailerViewHolder_ViewBinding implements Unbinder {
  private TrailerAdapter.TrailerViewHolder target;

  @UiThread
  public TrailerAdapter$TrailerViewHolder_ViewBinding(TrailerAdapter.TrailerViewHolder target,
      View source) {
    this.target = target;

    target.mTextTrailerHeader = Utils.findRequiredViewAsType(source, R.id.text_list_trailer_header, "field 'mTextTrailerHeader'", TextView.class);
    target.mLinearPlayVideoTrailer = Utils.findRequiredViewAsType(source, R.id.linear_play_video_trailer, "field 'mLinearPlayVideoTrailer'", LinearLayout.class);
    target.mPlayVideoTrailer = Utils.findRequiredViewAsType(source, R.id.text_view_play_video_trailer, "field 'mPlayVideoTrailer'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TrailerAdapter.TrailerViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextTrailerHeader = null;
    target.mLinearPlayVideoTrailer = null;
    target.mPlayVideoTrailer = null;
  }
}
