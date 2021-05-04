package myteam.com;

import android.content.Intent;
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

public class DanhSachVideo extends AppCompatActivity implements VideoListAdapter.VieoItemListener {
    private Toolbar toolbar;
    private RecyclerView rvListVideo;
    private String title;

   private YouTubePlayer mYouTubePlayer;
    private YouTubePlayerView mYouTubePlayerView;

    private List<Lesson> lessonAndroidList;
    private List<Lesson> lessonCPPList;

    private List<Lesson> selectedLessonList;


    private void initData(int courseId) {
        lessonAndroidList = new ArrayList<>();
        lessonAndroidList.add(new Lesson("Lập Trình Android phần 1", "Bài học hướng dẫn sử dụng layout 1", "Sử dụng linearlayout,chia bố cục từ đầu", "EwRcw74iaZM", ""));
        lessonAndroidList.add(new Lesson("Lập Trình Android phần 2", "Bài học hướng dẫn sử dụng layout 2", "Sử dụng linearlayout,Relative", "_lSesdQDwq4", ""));
        lessonAndroidList.add(new Lesson("Lập Trình Android phần 3", "Bài học hướng dẫn sử dụng layout 2", "Sử dụng linearlayout,Relative", "F9mh_n2_kew", ""));

        List<Lesson> lessonPythonList = new ArrayList<>();
        lessonPythonList.add(new Lesson("Lập Trình Cơ Bản PYTHON Tự Học Cho Người Mới Bắt Đầu", "Hướng dẫn tự viết chương trình Python từ đâu và sử dụng Terminal trên Window mad Mac. Clip này phù hợp cho các bạn chưa biết gì về lập trình.","","oFgg7K2tpfk", "25:52"));
        lessonPythonList.add(new Lesson("Lập Trình Python Cho Mọi Người | Game Đấm Lá Kéo | Beginner", "Tự chơi game Đấm Lá Kéo với máy tính bằng Python cho người mới bắt đầu.","","HyovJpkPSfY", "25:06"));
        lessonPythonList.add(new Lesson("Lập Trình Trí Tuệ Nhân Tạo Cơ Bản Tự Học Cho Người Mới Bắt Đầu | Trợ Lý Ảo Python", "Hướng dẫn lập trình trí tuệ nhân tạo, nhận giạng giọng nói, xử lý ngôn ngữ tự nhiên AI - Artificial Intelligence cho người mới bắt đầu.","","wVboOz_O8rE", "29:58"));
        lessonPythonList.add(new Lesson("Lập Trình Phần Mềm Máy Tính Python Cơ Bản Tự Học Cho Người Mới Bắt Đầu | Đồng Hồ Đếm Ngược Python", "Hướng dẫn lập trình game, phần mềm, ứng dụng, tool trên máy tính bằng ngôn ngữ python cho người mới bắt đầu.","","WagJ-OjRtCM", "33:04"));

        List<Lesson> lessonJavaList = new ArrayList<>();
        lessonJavaList.add(new Lesson("[Khóa học lập trình Java đến OOP] - Bài 1: Giới thiệu Java | HowKteam", "[Khóa học lập trình Java đến OOP] - Bài 1: Giới thiệu Java | HowKteam","","3gtOAlcovoQ", "09:10"));
        lessonJavaList.add(new Lesson("[Khóa học lập trình Java đến OOP] - Bài 2: Cài đặt môi trường Java | HowKteam", "[Khóa học lập trình Java đến OOP] - Bài 2: Cài đặt môi trường Java | HowKteam","","KjMRn1YQcLc", "14:20"));
        lessonJavaList.add(new Lesson("[Khóa học lập trình Java đến OOP] - Bài 3: Chương trình Java đầu tiên | HowKteam", "[Khóa học lập trình Java đến OOP] - Bài 3: Chương trình Java đầu tiên | HowKteam","","jIQmebw9Va", "09:58"));
        lessonJavaList.add(new Lesson("[Khóa học lập trình Java đến OOP] - Bài 4: Biến trong Java | HowKteam", "[Khóa học lập trình Java đến OOP] - Bài 4: Biến trong Java | HowKteam","","G2mCSTtBojM", "15:08"));
        lessonJavaList.add(new Lesson("[Khóa học lập trình Java đến OOP] - Bài 5: Kiểu dữ liệu trong Java | HowKteam", "[Khóa học lập trình Java đến OOP] - Bài 5: Kiểu dữ liệu trong Java | HowKteam","","4k_5vWY2wps", "09:31"));

        List<Lesson> lessonPHPList = new ArrayList<>();
        lessonPHPList.add(new Lesson("[Khóa học lập trình PHP]", "Hướng dẫn học lập PHP căn bản - 01","","0u4ACXpLTmI", "26:28"));
        lessonPHPList.add(new Lesson("[Khóa học lập trình PHP]", "Lập trình PHP basic - Biến, hằng, toán tử và mảng trong PHP","","JHhgnaoNBtA", "19:09"));

        lessonCPPList = new ArrayList<>();
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 0: Tổng quan về khóa học Lập trình C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 0: Tổng quan về khóa học Lập trình C++ | HowKteam", "WS05AU6YYm4", "2:02"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 1: Giới thiệu về C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 1: Giới thiệu về C++ | HowKteam", "ILr_rU-lISk", "4:03"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 2: Kiểu Boolean và Câu điều kiện If | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 9: Kiểu luận lý Boolean  và Câu điều kiện If trong C++ | HowKteam", "3-G-MLXj5n0", "8:36"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 3: Xây dựng chương trình C++ đầu tiên | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 3: Xây dựng chương trình C++ đầu tiên | HowKteam", "q8UGqw6Cbnk", "18:37"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 4: Xây dựng chương trình C++ đầu tiên | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 4: Cấu trúc một chương trình C++ | HowKteam", "IXzH3pYM_bg", "10:29"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 5: Kinh nghiệm về Ghi chú trong C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 5: Kinh nghiệm về Ghi chú trong C++ | HowKteam", "Z-laY5MmTIE", "21:00"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 6: Biến trong C++ (Variables in C++) | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 6: Biến trong C++ (Variables in C++) | HowKteam", "i3nJyEt42Y8", "13:52"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 7: Số tự nhiên và Số chấm động trong C++ | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 7: Số tự nhiên và Số chấm động trong C++ (Integer, Floating point) | HowKteam", "wE3WhKbExN8", "21:52"));
        lessonCPPList.add(new Lesson("[Khóa học lập trình C++ Cơ bản]", "Bài 8: Kiểu ký tự trong C++ (Character) | HowKteam", "[Khóa học lập trình C++ Cơ bản] - Bài 8: Kiểu ký tự trong C++ (Character) | HowKtea", "wE3WhKbExN8", "21:52"));

        switch (courseId) {
            case 1:
                selectedLessonList = lessonAndroidList;
                break;
            case 2:
                selectedLessonList = lessonCPPList;
                break;
            case 3:
                selectedLessonList = lessonJavaList;
            case 4:
                selectedLessonList = lessonPHPList;
            case 5:
                selectedLessonList = lessonPythonList;
                break;
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Bundle bundle = getIntent().getExtras();
        Course course = (Course) bundle.get(Constants.KEY_COURSE);
        title = course != null ? course.namecourse : "";

        initData(course.id);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> finish());

        toolbar.setTitle(title);

        rvListVideo = findViewById(R.id.rv_list_video);
        rvListVideo.setLayoutManager(new LinearLayoutManager(this));
        rvListVideo.setAdapter(new VideoListAdapter(getApplicationContext(), selectedLessonList, this));



        mYouTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(mYouTubePlayerView);

        mYouTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = selectedLessonList.get(0).getVideoId();
                mYouTubePlayer = youTubePlayer;
                mYouTubePlayer.cueVideo(videoId, 0);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClickVideoItem(final String videoId) {
        mYouTubePlayer.loadVideo(videoId, 0);
        mYouTubePlayer.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mYouTubePlayerView.release();
    }
}
