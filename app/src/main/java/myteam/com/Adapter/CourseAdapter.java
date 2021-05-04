package myteam.com.Adapter;

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

import myteam.com.OnCourseViewClick;
import myteam.com.R;
import myteam.com.model.Course;

public class CourseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private final List<Course> mCourseList;
    private final OnCourseViewClick mOnCourseViewClick;
    private final int BANNER_VIEW = 1;

    public CourseAdapter(Context mContext, List<Course> mCourseList, OnCourseViewClick onClickListener) {
        this.mContext = mContext;
        this.mCourseList = mCourseList;
        this.mOnCourseViewClick = onClickListener;
    }

    private enum VIEW_TYPE {
        BANNER(0, R.layout.view_banner_home),
        COURSE_ITEM(1, R.layout.view_course_item);

        private int typeId;
        private int layoutId;

        VIEW_TYPE(int typeId,int layoutId) {
            this.layoutId = layoutId;
            this.typeId = typeId;
        }

        public int getLayoutId() {
            return layoutId;
        }

        public int getTypeId() {
            return typeId;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view;

        switch (viewType) {
            case 1:
                view = inflater.inflate(R.layout.view_course_item, parent, false);
                return new CourseViewHolder(view);
            default:
                view = inflater.inflate(R.layout.view_banner_home, parent, false);
                return new BannerViewHolder(view);        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case 0: {
                if (holder instanceof BannerViewHolder) {
                    BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                }
                break;
            }
            case 1: {
                final Course course = mCourseList.get(position - BANNER_VIEW);

                if (holder instanceof CourseViewHolder) {
                    CourseViewHolder courseViewHolder = (CourseViewHolder) holder;
                    courseViewHolder.namecourse.setText(course.namecourse);
                    courseViewHolder.decription.setText(course.decription);
                    courseViewHolder.episode.setText(course.episode);
                    courseViewHolder.courseView.setOnClickListener(v -> mOnCourseViewClick.setOnClick(course));
                    Glide.with(mContext)
                            .load(course.imageCourse).into(courseViewHolder.image_Course);
                }
                break;
            }

            default:
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return VIEW_TYPE.BANNER.getTypeId();
            default:
                return VIEW_TYPE.COURSE_ITEM.getTypeId();
        }
    }

    @Override
    public int getItemCount() {
        return BANNER_VIEW + mCourseList.size();
    }

    private static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView namecourse;
        TextView decription;
        TextView episode;
        ImageView image_Course;
        View courseView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            namecourse = itemView.findViewById(R.id.course_name);
            decription = itemView.findViewById(R.id.decription_course);
            episode = itemView.findViewById(R.id.episode_course);
            image_Course = itemView.findViewById(R.id.image_course);
            courseView = itemView.findViewById(R.id.course_view);
        }
    }

    private static class BannerViewHolder extends RecyclerView.ViewHolder {
        View bannerView;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}