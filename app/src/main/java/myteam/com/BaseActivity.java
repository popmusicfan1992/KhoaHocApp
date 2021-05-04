package myteam.com;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.data.DataHolder;

import java.util.List;

//import myteam.com.database.DataHolder;
import myteam.com.model.Course;

public abstract class BaseActivity extends AppCompatActivity {
    private List<Course> courseList;
    public List<Course> getData() {return courseList;}
    public void setData(List<Course> courseList) {this.courseList = courseList;}

//    private static final DataHolder holder = new DataHolder();
//    public static DataHolder getInstance() {return holder;}
}
