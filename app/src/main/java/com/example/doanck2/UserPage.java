package com.example.doanck2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    Button btnChangePass, btnPolicy, btnContact, btnQues,btnEditAcc;
    ImageButton imbCamera;
    ImageView imvAva;
    LinearLayout sheetOpenCamera, sheetOpenGallery;
    BottomSheetDialog sheetDialog;
    ActivityResultLauncher<Intent> activityResultLauncher;
    boolean isCamera;

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
        Intent nhanUsername1 = getIntent();
        String username1 = nhanUsername1.getStringExtra("UserNametoUsers");
        Intent nhanUsername2 = getIntent();
        String username2 = nhanUsername2.getStringExtra("UsernameFromChangePhoto");
        if (username1 == null) {
            byte[] photo = General.ADB.ShowInfo(username2).getBlob(7);
            Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
            imvAva.setImageBitmap(bitmap);
            txtIdUser.setText(General.ADB.ShowInfo(username2).getString(0));
            txtNameUser.setText(General.ADB.ShowInfo(username2).getString(3));
            txtPhoneUser.setText(General.ADB.ShowInfo(username2).getString(4));
            txtEmailUser.setText(General.ADB.ShowInfo(username2).getString(5));
        } else {
            byte[] photo = General.ADB.ShowInfo(username1).getBlob(7);
            Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
            imvAva.setImageBitmap(bitmap);
            txtIdUser.setText(General.ADB.ShowInfo(username1).getString(0));
            txtNameUser.setText(General.ADB.ShowInfo(username1).getString(3));
            txtPhoneUser.setText(General.ADB.ShowInfo(username1).getString(4));
            txtEmailUser.setText(General.ADB.ShowInfo(username1).getString(5));
        }
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
                Intent nhanUsername = getIntent();
                String fullname = nhanUsername.getStringExtra("UserNametoUsers");
               Intent intent = new Intent(UserPage.this,User_Page_ChangePass.class);
               intent.putExtra("UserNametoChangePass",fullname);
               startActivity(intent);
            }
        });
        btnEditAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nhanUsername = getIntent();
                String username1 = nhanUsername.getStringExtra("UserNametoUsers");

                if (username1 == null){
                    Intent nhanUsername2 = getIntent();
                    String username2 = nhanUsername2.getStringExtra("UsernameFromChangePhoto");
                    Intent intent = new Intent(UserPage.this,User_Page_Edit.class);
                    intent.putExtra("UserNametoChange",username2);
                    startActivity(intent);

                }else {
                    Intent intent = new Intent(UserPage.this,User_Page_Edit.class);
                    intent.putExtra("UserNametoChange",username1);

                    startActivity(intent);

                }
            }
        });
        imbCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nhanUsername = getIntent();
                String username = nhanUsername.getStringExtra("UserNametoUsers");

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
                        Intent nhanUsername = getIntent();
                        String username1 = nhanUsername.getStringExtra("UserNametoUsers");

                        if (username1 == null){
                            Intent nhanUsername2 = getIntent();
                            String username2 = nhanUsername2.getStringExtra("UsernameFromChangePhoto");
                            Intent intent = new Intent(UserPage.this,HomePage.class);
                            intent.putExtra("UserNametoHP",username2);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                        }else {
                            Intent intent = new Intent(UserPage.this,HomePage.class);
                            intent.putExtra("UserNametoHP",username1);

                            startActivity(intent);
                            overridePendingTransition(0,0);
                        }
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