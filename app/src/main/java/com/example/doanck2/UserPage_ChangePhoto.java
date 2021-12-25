package com.example.doanck2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.utils.General;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UserPage_ChangePhoto extends AppCompatActivity {

    Button  btnSave, btnCancel;
    ImageView imvPhoto;
    ImageButton btnCapture;
    LinearLayout sheetOpenCamera, sheetOpenGallery;

    BottomSheetDialog sheetDialog;
    ActivityResultLauncher<Intent> activityResultLauncher;
    boolean isCamera;
    String username = General.Us.getUsername();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page_change_photo);



        linkViews();
        showInfo();
        createSheetDialog();
        addEvents();



        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    if (isCamera) {
                        Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                        imvPhoto.setImageBitmap(bitmap);
                    } else {
                        Uri uri = result.getData().getData();
                        if (uri != null) {
                            InputStream inputStream = null;
                            try {
                                inputStream = getContentResolver().openInputStream(uri);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                imvPhoto.setImageBitmap(bitmap);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }


                        }
                    }
                }
            }
        });
    }

    private void showInfo() {
        byte[] photo = General.ADB.ShowInfo(username).getBlob(7);
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
        imvPhoto.setImageBitmap(bitmap);

    }

    private void addEvents() {
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open bottom dialog
                sheetDialog.show();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert Data

                boolean check= General.ADB.updatePhoto(username,convertPhoto());
                if (check){
                    Toast.makeText(UserPage_ChangePhoto.this, "Cập nhật hình ảnh thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserPage_ChangePhoto.this,UserPage.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(UserPage_ChangePhoto.this, "Fail!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private byte[] convertPhoto() {
        BitmapDrawable drawable = (BitmapDrawable) imvPhoto.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();

    }

    private void createSheetDialog() {
        if (sheetDialog == null) {
            View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_camera_open, null);
            sheetOpenCamera = view.findViewById(R.id.sheetOpenCamera);
            sheetOpenCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Open camera
                    isCamera = true;
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            sheetOpenGallery = view.findViewById(R.id.sheetOpenGallery);
            sheetOpenGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Open Gallery
                    isCamera = false;
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            sheetDialog = new BottomSheetDialog(this);
            sheetDialog.setContentView(view);

        }
    }

    private void linkViews() {

        btnCapture = findViewById(R.id.btnCapture);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        imvPhoto = findViewById(R.id.imvPhoto);

    }

}