package com.example.doanck2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utils.General;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User_Page_Edit extends AppCompatActivity {

    ImageButton imbBack;
    EditText edtName,edtEmail,edtPhone,edtBirth;
    TextView txtId;
    Button btnUpdate;
    String username = General.Us.getUsername();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page_edit);
        linkViews();
        showInfo();
        setEvents();
    }

    private void showInfo() {
        txtId.setText(General.ADB.ShowInfo(username).getString(0));
        edtEmail.setText(General.ADB.ShowInfo(username).getString(5));
        edtName.setText(General.ADB.ShowInfo(username).getString(3));
        edtPhone.setText(General.ADB.ShowInfo(username).getString(4));
        edtBirth.setText(General.ADB.ShowInfo(username).getString(6));
    }

    private void setEvents() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String phoneS = edtPhone.getText().toString();
                int phone = Integer.parseInt(phoneS);
                String birth = edtBirth.getText().toString();
                if (name.equals("") || email.equals("") ||phoneS.equals("")||birth.equals("")){
                    Toast.makeText(User_Page_Edit.this, "Vui lòng điền đủ các ô thông tin!", Toast.LENGTH_SHORT).show();
                }else{
                    if (General.ADB.checkEmail(email)){
                        Toast.makeText(User_Page_Edit.this, "Email đã có người sử dụng!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (General.ADB.checkPhone(phoneS)){
                            Toast.makeText(User_Page_Edit.this, "Số điện thoại đã có người sử dụng", Toast.LENGTH_SHORT).show();
                        }else {
                            General.ADB.updateName(username, name);
                            General.ADB.updateEmail(username, email);
                            General.ADB.updatePhone(username, phone);
                            General.ADB.updateBirth(username, birth);
                            Toast.makeText(User_Page_Edit.this, "Cập nhật thông tin thành công!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(User_Page_Edit.this, UserPage.class);
                            startActivity(intent);
                        }
                        }

                }
            }
        });


    }


    private void linkViews() {
        imbBack =findViewById(R.id.imbBack);
        edtName = findViewById(R.id.edtFullNameUserChange);
        txtId = findViewById(R.id.txtIdUserChange);
        edtPhone = findViewById(R.id.edtPhoneUserChange);
        edtEmail = findViewById(R.id.edtEmailUserChange);
        btnUpdate = findViewById(R.id.btnUpdateInfo);
        edtBirth =findViewById(R.id.edtBirthUserChange);

    }

}