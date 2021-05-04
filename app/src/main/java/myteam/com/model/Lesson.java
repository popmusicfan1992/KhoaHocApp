package myteam.com.model;

public class Lesson {
    private String duration;
    private String title;
    private String decription;
    private String turorial;
    private String videoId;

    public Lesson(String title, String decription, String turorial, String videoId, String duration) {
        this.title = title;
        this.decription = decription;
        this.turorial = turorial;
        this.videoId = videoId;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getTurorial() {
        return turorial;
    }

    public void setTurorial(String turorial) {
        this.turorial = turorial;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
