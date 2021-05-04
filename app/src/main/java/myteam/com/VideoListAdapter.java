package myteam.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import myteam.com.Utils.Common;
import myteam.com.model.Lesson;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoItemViewHolder> {
    private List<Lesson> mLessonList;
    private Context mContext;
    private VieoItemListener mVieoItemListener;

    public VideoListAdapter(Context context, List<Lesson> lessonList, VieoItemListener vieoItemListener) {
        this.mContext = context;
        this.mLessonList = lessonList;
        this.mVieoItemListener = vieoItemListener;
    }

    @NonNull
    @Override
    public VideoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_lesson_item, parent, false);
        return new VideoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoItemViewHolder holder, int position) {
        Lesson lesson = mLessonList.get(position);
        Glide.with(mContext)
                .load(Common.getYoutubeThumbnailUrlFromVideoId(lesson.getVideoId()))
                .into(holder.img);
        holder.tvTitle.setText(lesson.getTitle());
        holder.tvDescription.setText(lesson.getDecription());
        holder.videoItemWrapper.setOnClickListener(view -> mVieoItemListener.onClickVideoItem(lesson.getVideoId()));
        holder.tvDuration.setText(lesson.getDuration());
    }

    public interface VieoItemListener {
        void onClickVideoItem(String videoId);
    }

    @Override
    public int getItemCount() {
        return mLessonList.size();
    }

    public static class VideoItemViewHolder extends RecyclerView.ViewHolder {
        View imgWrapper;
        ImageView img;
        TextView tvTitle;
        TextView tvDescription;
        View videoItemWrapper;
        TextView tvDuration;

        public VideoItemViewHolder(@NonNull View itemView) {
            super(itemView);

            videoItemWrapper = itemView.findViewById(R.id.lesson_item_wrapper);
            imgWrapper = itemView.findViewById(R.id.img_course_wrapper);
            img = itemView.findViewById(R.id.img_course);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvDuration = itemView.findViewById(R.id.tv_duration);
        }


    }
}
