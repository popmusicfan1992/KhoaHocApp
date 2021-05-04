package myteam.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import myteam.com.model.Student;

public class AccountActivity extends AppCompatActivity {
    private TextView username_1,username_2,MaSv;
    private Student student;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout image_clickback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        username_1 = (TextView) findViewById(R.id.username_1);
        username_2 = (TextView) findViewById(R.id.username_2);
        MaSv = (TextView) findViewById(R.id.MaSv);
        image_clickback = findViewById(R.id.img_clickback);
        student = (Student) getIntent().getSerializableExtra("student2");
        if(student!=null){
            username_1.setText(student.getUsername());
            username_2.setText(student.getUsername());
            MaSv.setText(student.getId());
        }
        image_clickback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nagivation__bottom);
        bottomNavigationView.setSelectedItemId(R.id.menu_account);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_favorite:

                    startActivity(new Intent(getApplicationContext(), DoItActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.menu_home:

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






    }
