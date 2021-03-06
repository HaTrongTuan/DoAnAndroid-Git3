package com.example.doanck2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDataBase;
import com.example.utils.General;

import java.io.ByteArrayOutputStream;

public class DangKyPhone extends AppCompatActivity {

    TextView txtEmailDk;
    ImageView imvback;
    EditText edtPhonePhone, edtNamePhone, edtPassPhone, edtRePassPhone;
    Button btnActDkPhone;
    CheckBox chkDieuKhoan;
    AccountDataBase ADB = new AccountDataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_phone);

        linkViews();
        dangKyPhone();
        transToEmail();
        back();

    }

    private void back() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(DangKyPhone.this, DangNhap.class);
                startActivity(intentTranstoPhone);
            }
        });
    }

    private byte[] convertPhoto(int image) {
        BitmapDrawable drawable = (BitmapDrawable) getDrawable(image);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
    }


    private void dangKyPhone() {

        btnActDkPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check dữ liệu
                String PhonePhone = edtPhonePhone.getText().toString().trim();
                String NamePhone = edtNamePhone.getText().toString().trim();
                String PassPhone = edtPassPhone.getText().toString().trim();
                String RePassPhone = edtRePassPhone.getText().toString().trim();
                if (PhonePhone.equals("")||NamePhone.equals("")|| PassPhone.equals("")||RePassPhone.equals("")) {
                    Toast.makeText(DangKyPhone.this, "Vui lòng điền hết các ô!", Toast.LENGTH_SHORT).show();
                }else {
                    if(chkDieuKhoan.isChecked()==false){
                        Toast.makeText(DangKyPhone.this, "Bạn chưa đồng ý điều khoản!", Toast.LENGTH_SHORT).show();
                    }else{
                    if (RePassPhone.equals(PassPhone)) {
                        Boolean checkUser = General.ADB.checkUsername(NamePhone);
                        if (!checkUser ) {
                            Boolean insert = General.ADB.insertData(NamePhone, PassPhone, NamePhone, PhonePhone, "Blank", "Blank", convertPhoto(R.drawable.unknownava));
                            if (insert ) {
                                Intent intentActDangKyEmail = new Intent(DangKyPhone.this, DangNhap.class);
                                intentActDangKyEmail.putExtra("NamePhone_To_Login", NamePhone);

                                startActivity(intentActDangKyEmail);
                                Toast.makeText(DangKyPhone.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();

                            }
                        }else{
                            Toast.makeText(DangKyPhone.this, "Tài khoản đã có sẵn, vui lòng sử dụng tài khoản khác!", Toast.LENGTH_SHORT).show();
                        }}else{
                        Toast.makeText(DangKyPhone.this, "Nhập lại mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
                    }
                }}
            }}
        );
    }

    private void transToEmail() {
        txtEmailDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTranstoMail = new Intent(DangKyPhone.this, DangKyMail.class);
                startActivity(intentTranstoMail);
            }
        });
    }

    private void linkViews() {
        txtEmailDk = findViewById(R.id.txtEmailDK);
        edtPhonePhone =findViewById(R.id.edtPhone);
        edtNamePhone = findViewById(R.id.edtNamePhone);
        edtPassPhone= findViewById(R.id.edtPassPhone);
        edtRePassPhone = findViewById(R.id.edtRePassPhone);
        btnActDkPhone = findViewById(R.id.btnActDkPhone);
        imvback = findViewById(R.id.back);
        chkDieuKhoan =findViewById(R.id.chkQuyDinhPhone);
    }
}