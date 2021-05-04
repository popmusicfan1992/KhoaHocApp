package myteam.com.model;

import java.io.Serializable;

public class  Video12 implements Serializable {
    private String name;
    private String link;
    private String des;
    public Video12(){

    }
    public Video12(String name, String link,String des){
        this.name=name;
        this.link=link;
        this.des=des;

    }

    public String getDes() {
        return des;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }
}

