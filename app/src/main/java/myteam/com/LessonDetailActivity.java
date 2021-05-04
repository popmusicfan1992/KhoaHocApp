package myteam.com;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import myteam.com.model.Course;
import myteam.com.model.Lesson;

public class LessonDetailActivity extends AppCompatActivity {
//    private Toolbar toolbar;
//    private RecyclerView rvListVideo;
//    private String title;
//    private YouTubePlayer mYouTubePlayer;
//    private YouTubePlayerView mYouTubePlayerView;
//    private List<Lesson> lessonAndroidList;
//    private List<Lesson> lessonCPPList;
//    private List<Lesson> selectedLessonList;
//
//    private void initData() {
//        lessonAndroidList = new ArrayList<>();
//        lessonAndroidList.add(new Lesson("Lập Trình Android phần 1", "Bài học hướng dẫn sử dụng layout 1", "Sử dụng linearlayout,chia bố cục từ đầu", "EwRcw74iaZM", ""));
//        lessonAndroidList.add(new Lesson("Lập Trình Android phần 2", "Bài học hướng dẫn sử dụng layout 2", "Sử dụng linearlayout,Relative", "_lSesdQDwq4", ""));
//        lessonAndroidList.add(new Lesson("Lập Trình Android phần 3", "Bài học hướng dẫn sử dụng layout 2", "Sử dụng linearlayout,Relative", "F9mh_n2_kew", ""));
//
//        lessonCPPList = new ArrayList<>();
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 0: Tổng quan về khóa học Lập trình C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 0: Tổng quan về khóa học Lập trình C++ | HowKteam", "WS05AU6YYm4", "2:02"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 1: Giới thiệu về C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 1: Giới thiệu về C++ | HowKteam", "ILr_rU-lISk", "4:03"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 2: Kiểu Boolean và Câu điều kiện If | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 9: Kiểu luận lý Boolean  và Câu điều kiện If trong C++ | HowKteam", "3-G-MLXj5n0", "8:36"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 3: Xây dựng chương trình C++ đầu tiên | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 3: Xây dựng chương trình C++ đầu tiên | HowKteam", "q8UGqw6Cbnk", "18:37"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 4: Xây dựng chương trình C++ đầu tiên | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 4: Cấu trúc một chương trình C++ | HowKteam", "IXzH3pYM_bg", "10:29"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 5: Kinh nghiệm về Ghi chú trong C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 5: Kinh nghiệm về Ghi chú trong C++ | HowKteam", "Z-laY5MmTIE", "21:00"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 6: Biến trong C++ (Variables in C++) | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 6: Biến trong C++ (Variables in C++) | HowKteam", "i3nJyEt42Y8", "13:52"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 7: Số tự nhiên và Số chấm động trong C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 7: Số tự nhiên và Số chấm động trong C++ (Integer, Floating point) | HowKteam", "wE3WhKbExN8", "21:52"));
//        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 8: Kiểu ký tự trong C++ (Character) | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 8: Kiểu ký tự trong C++ (Character) | HowKtea", "wE3WhKbExN8", "21:52"));
//
//        selectedLessonList = lessonCPPList;
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_video);
//        initData();
//
//        Bundle bundle = getIntent().getExtras();
//        Course course = (Course) bundle.get(Constants.KEY_COURSE);
//        title = course != null ? course.namecourse : "";
//
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(title);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        toolbar.setNavigationOnClickListener(v -> finish());
//
//        toolbar.setTitle(title);
//
//        rvListVideo = findViewById(R.id.rv_list_video);
//        rvListVideo.setLayoutManager(new LinearLayoutManager(this));
//        rvListVideo.setAdapter(new VideoListAdapter(getApplicationContext(), selectedLessonList, this));
//
//        mYouTubePlayerView = findViewById(R.id.youtube_player_view);
//        getLifecycle().addObserver(mYouTubePlayerView);
//
//        mYouTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                String videoId = selectedLessonList.get(0).getVideoId();
//                mYouTubePlayer = youTubePlayer;
//                mYouTubePlayer.cueVideo(videoId, 0);
//            }
//        });
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
//
//    @Override
//    public void onClickVideoItem(final String videoId) {
//        mYouTubePlayer.loadVideo(videoId, 0);
//        mYouTubePlayer.play();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mYouTubePlayerView.release();
//    }
}
