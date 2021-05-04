package myteam.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CourseDto {
    @SerializedName("Course")
    public List<Course> courses;
}
