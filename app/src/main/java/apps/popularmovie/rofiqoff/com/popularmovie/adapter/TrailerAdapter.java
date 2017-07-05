package apps.popularmovie.rofiqoff.com.popularmovie.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import apps.popularmovie.rofiqoff.com.popularmovie.R;
import apps.popularmovie.rofiqoff.com.popularmovie.model.TrailerModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rofiqoff on 7/4/17.
 */

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {

    Activity activity;
    List<TrailerModel.TrailerData> trailers;

    public TrailerAdapter(Activity activity, List<TrailerModel.TrailerData> trailers) {
        this.activity = activity;
        this.trailers = trailers;
    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_trailer, parent, false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TrailerViewHolder holder, final int position) {
        if (!trailers.isEmpty()){
            holder.mTextTrailerHeader.setText("Trailer "+(position+1));
            holder.mTextTrailerHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.mLinearPlayVideoTrailer.getVisibility() == View.GONE){
                        holder.mLinearPlayVideoTrailer.setVisibility(View.VISIBLE);
                    } else if (holder.mLinearPlayVideoTrailer.getVisibility() == View.VISIBLE){
                        holder.mLinearPlayVideoTrailer.setVisibility(View.GONE);
                    }
                }
            });

            holder.mPlayVideoTrailer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+trailers.get(position).getKey())));
                }
            });

        } else {
            holder.mTextTrailerHeader.setText("This content was not has a video trailer yet.");
        }
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_list_trailer_header) TextView mTextTrailerHeader;
        @BindView(R.id.linear_play_video_trailer) LinearLayout mLinearPlayVideoTrailer;
        @BindView(R.id.text_view_play_video_trailer) TextView mPlayVideoTrailer;

        public TrailerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
