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
    TextView txtId,txtOldFullname,txtOldPhone,txtOldEmail,txtOldBirh;
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
        txtOldEmail.setText(General.ADB.ShowInfo(username).getString(5));
        txtOldFullname.setText(General.ADB.ShowInfo(username).getString(3));
        txtOldPhone.setText(General.ADB.ShowInfo(username).getString(4));
        txtOldBirh.setText(General.ADB.ShowInfo(username).getString(6));
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
               String oldEmail = General.ADB.ShowInfo(username).getString(5);
               String oldPhone = General.ADB.ShowInfo(username).getString(4);
                String name = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String phoneS = edtPhone.getText().toString();
                int phone = Integer.parseInt(phoneS);
                String birth = edtBirth.getText().toString();
                if (name.equals("") || email.equals("") ||phoneS.equals("")||birth.equals("")){
                    Toast.makeText(User_Page_Edit.this, "Vui l??ng ??i???n ????? c??c ?? th??ng tin!", Toast.LENGTH_SHORT).show();
                }else{
                    if (General.ADB.checkEmail(email)&& email.equals(oldEmail)==false){
                        Toast.makeText(User_Page_Edit.this, "Email ???? c?? ng?????i s??? d???ng!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (General.ADB.checkPhone(phoneS)&& phoneS.equals(oldPhone)==false){
                            Toast.makeText(User_Page_Edit.this, "S??? ??i???n tho???i ???? c?? ng?????i s??? d???ng", Toast.LENGTH_SHORT).show();
                        }else {
                            General.ADB.updateName(username, name);
                            General.ADB.updateEmail(username, email);
                            General.ADB.updatePhone(username, phone);
                            General.ADB.updateBirth(username, birth);
                            Toast.makeText(User_Page_Edit.this, "C???p nh???t th??ng tin th??nh c??ng!", Toast.LENGTH_SHORT).show();
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
        txtOldFullname = findViewById(R.id.txtOldFullname);
        txtOldBirh = findViewById(R.id.txtOldBirth);
        txtOldEmail = findViewById(R.id.txtOldEmail);
        txtOldPhone = findViewById(R.id.txtOldPhone);

    }

}