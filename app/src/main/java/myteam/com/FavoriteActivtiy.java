//package myteam.com;
//
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.widget.Toolbar;
//
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import myteam.com.Adapter.CourseAdapter;
//import myteam.com.model.Course;
//
//public class FavoriteActivtiy extends BaseActivity {
//    RecyclerView recyclerView;
//    CourseAdapter courseAdapter= new CourseAdapter(getApplicationContext(), new ArrayList<>(), new OnCourseViewClick() {
//        @Override
//        public void setOnClick(Course course) {
//
//        }
//    });
//    List<Course> courseList;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.activity_favorite);
//        recyclerView = findViewById(R.id.recycle_course);
//        recyclerView.setAdapter(courseAdapter);
//        setSupportActionBar(findViewById(R.id.toolbar));
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
////        if (getInstance().getData() != null) {
////            courseList = getInstance().getData();
////            courseAdapter.setCourseList(courseList);
////            courseAdapter.notifyDataSetChanged();
////        }
//
//    }
//}
