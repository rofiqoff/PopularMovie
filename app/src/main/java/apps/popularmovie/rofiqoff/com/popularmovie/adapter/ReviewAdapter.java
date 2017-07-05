package apps.popularmovie.rofiqoff.com.popularmovie.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import apps.popularmovie.rofiqoff.com.popularmovie.R;
import apps.popularmovie.rofiqoff.com.popularmovie.model.ReviewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rofiqoff on 7/4/17.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private Activity activity;
    private List<ReviewModel.ReviewData> reviews;

    public ReviewAdapter(Activity activity, List<ReviewModel.ReviewData> reviews) {
        this.activity = activity;
        this.reviews = reviews;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_review, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ReviewViewHolder holder, int position) {

        if (!reviews.isEmpty()) {
            holder.mReviewHeader.setText("Review " + (position+1));
            holder.mReviewHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.mLinearReviewContent.getVisibility() == View.GONE){
                        holder.mLinearReviewContent.setVisibility(View.VISIBLE);
                    } else if (holder.mLinearReviewContent.getVisibility() == View.VISIBLE){
                        holder.mLinearReviewContent.setVisibility(View.GONE);
                    }
                }
            });

            holder.mTextAuthor.setText(reviews.get(position).getAuthor());
            holder.mTextReviewContent.setText(reviews.get(position).getContent());
            holder.mTextReviewUrl.setText(reviews.get(position).getUrl());

        } else {
            holder.mReviewHeader.setText("This content was not has a review yet.");
        }

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_list_review_header) TextView mReviewHeader;
        @BindView(R.id.linear_content_review) LinearLayout mLinearReviewContent;
        @BindView(R.id.text_author) TextView mTextAuthor;
        @BindView(R.id.text_review_content) TextView mTextReviewContent;
        @BindView(R.id.text_review_url) TextView mTextReviewUrl;

        public ReviewViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
