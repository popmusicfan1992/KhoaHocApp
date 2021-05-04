package myteam.com;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import myteam.com.Adapter.CourseAdapter;
import myteam.com.database.APIClient;
import myteam.com.database.ResponseAPI;
import myteam.com.model.Course;
import myteam.com.model.CourseDto;
import myteam.com.model.Student;
import okhttp3.Response;


public class  HomeActivity extends BaseActivity implements OnCourseViewClick {
    private RecyclerView recyclerView;

    private BottomNavigationView bottomNavigationView;
    private TextView tvStudent;
    private Student student;
    private Handler mHandler;
    private View banner;
    private Toolbar mToolbar;
    private boolean isLoading = true;
    private View mAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAnimationView = findViewById(R.id.animationView);
        mAnimationView.setVisibility(View.VISIBLE);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Trang chủ");
        setSupportActionBar(mToolbar);

        student = (Student) getIntent().getSerializableExtra("student");
        tvStudent = findViewById(R.id.textUsername);
        if (student != null) {
            tvStudent.setText(student.getUsername());
        }

        mHandler = new Handler(Looper.getMainLooper());

        recyclerView = findViewById(R.id.recycle_course);

        banner =  LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_banner_home, null);
        fetchAPIGetCourses();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nagivation__bottom);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_favorite:
                    startActivity(new Intent(getApplicationContext(), DoItActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.menu_home:
                    if (item.isChecked())
                        break;
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.menu_account:
                    if (item.isChecked())
                        break;

                    startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void showCourseList(CourseDto courseDto) {
        if (courseDto == null) {
            recyclerView.removeAllViewsInLayout();
            return;
        }

        CourseAdapter adapter = new CourseAdapter(this, courseDto.courses, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mHandler.postDelayed(() -> hideLoadingAnimation(), 1000);
    }

    @Override
    public void setOnClick(Course course) {
//        List<Course> list =  getInstance().getData();
//
//        if (list != null && list.size() != 0) {
//            if (list.contains(course)) {
//                list.remove(course);
//            } else {
//                list.add(course);
//            }
//        } else {
//            list = new ArrayList<>();
//            list.add(course);
//        }
//
//        getInstance().setData(list);


        Intent intent = new Intent(HomeActivity.this, DanhSachVideo.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.KEY_COURSE, course);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private final ResponseAPI responseAPICourse = new ResponseAPI() {
        @Override
        public void onSuccess(Response response) {
            if (response.code() == Constants.SUCCESS) {
                try {
                    CourseDto courseDto = new Gson().fromJson(response.body().string(), CourseDto.class);
                    // Update UI on Main Thread
                    mHandler.post(() -> showCourseList(courseDto));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // TODO
            }
        }

        @Override
        public void onFailure() {
            // TODO
            Log.d("API Course: ","Failed");
        }

    };

    private void hideLoadingAnimation() {
        mAnimationView.setVisibility(View.GONE);
        isLoading = false;
    }

    private void fetchAPIGetCourses() {
        // Call API Courses
        isLoading = true;
        APIClient.getAPICourse(APIClient.getInstance(getApplicationContext()), Constants.API_GET_COURSES, responseAPICourse);
    }
}