package com.myapp.anit.sharepreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DangnhapthanhcongActivity extends AppCompatActivity {
    TextView textView;
    Button btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhapthanhcong);
        init();
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String pwd = intent.getStringExtra("pwd");
        if(pwd.equals(intent.getStringExtra("pass"))){
            textView.setText("Hello: "+user);
        }else {
            textView.setText("Nhập sai password");
        }



        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        textView= (TextView) findViewById(R.id.tv);
        btnThoat= (Button) findViewById(R.id.btn_thoat);
    }
}
