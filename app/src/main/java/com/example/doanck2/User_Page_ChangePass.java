package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.utils.General;

public class User_Page_ChangePass extends AppCompatActivity {

    EditText edtPass, edtNewPass,edtReNewPass;
    Button btnUpdate;
    ImageButton imbBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page_change_pass);

        linkViews();
        getEvents();
    }

    private void getEvents() {
        Intent nhanUsername = getIntent();
        String username = nhanUsername.getStringExtra("UserNametoChangePass");
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PresentPass = edtPass.getText().toString().trim();
                String newPass = edtNewPass.getText().toString().trim();
                String newRePass = edtReNewPass.getText().toString().trim();
                if (PresentPass.equals("")||newPass.equals("")||newRePass.equals("")){
                    Toast.makeText(User_Page_ChangePass.this, "Vui lòng điền hết các ô!", Toast.LENGTH_SHORT).show();
                }else {
                if (!General.ADB.checkUsernamePassword(username,PresentPass)){
                    Toast.makeText(User_Page_ChangePass.this, "Mật khẩu hiện tại không đúng! ", Toast.LENGTH_SHORT).show();
                }else {
                    if (newPass.equals(PresentPass)) {
                        Toast.makeText(User_Page_ChangePass.this, "Mật khẩu mới trùng mật khẩu cũ!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!newPass.equals(newRePass)) {
                            Toast.makeText(User_Page_ChangePass.this, "Nhập lại mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                        } else {
                           General.ADB.updatePass( username,newPass);
                            Toast.makeText(User_Page_ChangePass.this, "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }}}
        });
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkViews() {
        edtPass = findViewById(R.id.edtPassPresent);
        edtNewPass = findViewById(R.id.edtPassNew);
        edtReNewPass = findViewById(R.id.edtPassNewConfirm);
        btnUpdate = findViewById(R.id.btnUpdatePass);
        imbBack = findViewById(R.id.imbBack);
    }


}