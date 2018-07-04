package com.myapp.anit.sharepreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button btnLogin;
    EditText edtUser,edtPassword;
    CheckBox ckbLuu;
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
            }
        });

    }

    private void doLogin() {
        Intent i = new Intent(MainActivity.this,DangnhapthanhcongActivity.class);
//        SharedPreferences pre = getSharedPreferences("my_data",MODE_PRIVATE);
        i.putExtra("user",edtUser.getText().toString());
        i.putExtra("pwd",edtPassword.getText().toString());
        i.putExtra("pass",pass);
        startActivity(i);
    }

    private void init() {
        btnLogin= (Button) findViewById(R.id.btn_login);
        edtUser= (EditText) findViewById(R.id.edt_user);
        edtPassword= (EditText) findViewById(R.id.edt_pass);
        ckbLuu= (CheckBox) findViewById(R.id.checkbox);
    }

    @Override
    protected void onPause() {
        super.onPause();
        savingPreference();
    }

    private void savingPreference() {
        SharedPreferences pre = getSharedPreferences("my_data",MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        boolean chb = ckbLuu.isChecked();
        if(!chb){
            editor.clear();
        }else{
            editor.putString("user",edtUser.getText().toString());
            editor.putString("pwd",edtPassword.getText().toString());
            editor.putBoolean("checked",chb);
        }

        editor.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        restorePreference();
    }

    private void restorePreference() {
        SharedPreferences pre = getSharedPreferences("my_data",MODE_PRIVATE);
        user = pre.getString("user","");
        pass = pre.getString("pwd","");
        boolean chb = pre.getBoolean("checked",true);
        if(chb){
            edtUser.setText(user);
            edtPassword.setText(pass);
        }
        ckbLuu.setChecked(chb);

    }
}
