package myteam.com.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class Course implements Serializable {
    @SerializedName("namecourse")
    public String namecourse;
    @SerializedName("decription")
    public String decription;
    @SerializedName("episode")
    public String episode;
    @SerializedName("image_course")
    public String imageCourse;
    @SerializedName("id")
    public Integer id;
}
