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

public class ReviewAdapter$ReviewViewHolder_ViewBinding implements Unbinder {
  private ReviewAdapter.ReviewViewHolder target;

  @UiThread
  public ReviewAdapter$ReviewViewHolder_ViewBinding(ReviewAdapter.ReviewViewHolder target,
      View source) {
    this.target = target;

    target.mReviewHeader = Utils.findRequiredViewAsType(source, R.id.text_list_review_header, "field 'mReviewHeader'", TextView.class);
    target.mLinearReviewContent = Utils.findRequiredViewAsType(source, R.id.linear_content_review, "field 'mLinearReviewContent'", LinearLayout.class);
    target.mTextAuthor = Utils.findRequiredViewAsType(source, R.id.text_author, "field 'mTextAuthor'", TextView.class);
    target.mTextReviewContent = Utils.findRequiredViewAsType(source, R.id.text_review_content, "field 'mTextReviewContent'", TextView.class);
    target.mTextReviewUrl = Utils.findRequiredViewAsType(source, R.id.text_review_url, "field 'mTextReviewUrl'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReviewAdapter.ReviewViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mReviewHeader = null;
    target.mLinearReviewContent = null;
    target.mTextAuthor = null;
    target.mTextReviewContent = null;
    target.mTextReviewUrl = null;
  }
}
