package com.example.doanck2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.utils.General;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class UserPage extends AppCompatActivity {

    TextView txtIdUser, txtNameUser, txtPhoneUser, txtEmailUser;
    Button btnChangePass, btnPolicy, btnContact, btnQues,btnEditAcc,btnLogOut;
    ImageButton imbCamera;
    ImageView imvAva;
    String username = General.Us.getUsername();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        linkViews();
        bottomNav();
        showInfo();
        setEvents();



    }

    public void showInfo() {

            byte[] photo = General.ADB.ShowInfo(username).getBlob(7);
            Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
            imvAva.setImageBitmap(bitmap);
            txtIdUser.setText(General.ADB.ShowInfo(username).getString(0));
            txtNameUser.setText(General.ADB.ShowInfo(username).getString(3));
            txtPhoneUser.setText(General.ADB.ShowInfo(username).getString(4));
            txtEmailUser.setText(General.ADB.ShowInfo(username).getString(5));
    }

    private void setEvents() {
        btnQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, User_Page_FAQ.class);
                startActivity(intent);

            }
        });
        btnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, User_Page_Rules.class);
                startActivity(intent);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, User_Page_Contact.class);
                startActivity(intent);
            }
        });
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(UserPage.this,User_Page_ChangePass.class);
               startActivity(intent);
            }
        });
        btnEditAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(UserPage.this,User_Page_Edit.class);
                    startActivity(intent);

            }
        });
        imbCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(UserPage.this,UserPage_ChangePhoto.class);
                    startActivity(intent);


            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(UserPage.this);
                dialog.setContentView(R.layout.confirm_dialog);
                dialog.setCanceledOnTouchOutside(false);
                TextView txtYes = dialog.findViewById(R.id.txtYes);
                TextView  txtNo = dialog.findViewById(R.id.txtNo);

                txtYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(UserPage.this,DangNhap.class);
                        startActivity(intent);
                    }
                });
                txtNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    private void linkViews() {
        txtIdUser = findViewById(R.id.txtIdUser);
        txtNameUser = findViewById(R.id.txtNameUser);
        txtPhoneUser = findViewById(R.id.txtPhoneUser);
        txtEmailUser = findViewById(R.id.txtEmailUser);
        btnChangePass = findViewById(R.id.btnChangePassword);
        btnPolicy = findViewById(R.id.btnDieuKhoan);
        btnContact = findViewById(R.id.btnLienhe);
        btnQues = findViewById(R.id.btnCauhoithuonggap);
        btnEditAcc = findViewById(R.id.btnEditAcc);
        imvAva = findViewById(R.id.imvAvatar);
        imbCamera = findViewById(R.id.imbCamera);
        btnLogOut = findViewById(R.id.btnLogOut);

    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.process:
                        startActivity(new Intent(getApplicationContext(),Process.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homepage:

                            Intent intent = new Intent(UserPage.this,HomePage.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);

                        return true;
                    case R.id.user:

                        return true;
                    case R.id.premium:
                        startActivity(new Intent(getApplicationContext(),Premium.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }
}