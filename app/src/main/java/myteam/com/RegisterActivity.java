package myteam.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import myteam.com.database.UserDao;
import myteam.com.database.UserDatabase;
import myteam.com.model.Student;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextMaSinhVien, editTextUsername, editTextPassword, editTextConfirmPassword;
    Button buttonRegister;
    TextView textViewLogin;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDatabase.class,"student").allowMainThreadQueries().build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msv = editTextMaSinhVien.getText().toString().trim();
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextConfirmPassword.getText().toString().trim();

                if (password.equals(passwordConf)){
                    Student student = new Student(msv,username,password);
                    userDao.insertStudent(student);
                    Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);
                }else {
                    Toast.makeText(RegisterActivity.this, "Password không chính xác",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init(){
        editTextMaSinhVien =findViewById(R.id.edMaSV);
        editTextUsername = findViewById(R.id.edUserName);
        editTextPassword = findViewById(R.id.edPassWord);
        editTextConfirmPassword =findViewById(R.id.edXacNhanMatKhau);
        buttonRegister = findViewById(R.id.btn_DangKi);
        textViewLogin = findViewById(R.id.tv_DangNhap);
    }
}