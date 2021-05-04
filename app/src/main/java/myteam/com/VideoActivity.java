package myteam.com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

import myteam.com.model.Video12;

public class VideoActivity extends AppCompatActivity {

    private Intent intent;
    private VideoView videoView;
    private  Toolbar toolbar;
    private TextView txtmota;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_);
        InitWidget();
        Init();


    }

    private void Init() {

        intent=getIntent();
        Video12 video12= (Video12) intent.getSerializableExtra("VIDEO");

        MediaController mediaController=new MediaController(this);
        videoView.setVideoURI(Uri.parse(video12.getLink()));
        videoView.setMediaController(mediaController);
        videoView.start();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(video12.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtmota.setText(video12.getDes());
    }

    private void InitWidget() {

        videoView=findViewById(R.id.vv);
        toolbar=findViewById(R.id.toolbar);
        txtmota=findViewById(R.id.txtmota);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
