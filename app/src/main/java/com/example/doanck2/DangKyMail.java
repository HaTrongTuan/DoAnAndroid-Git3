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

import java.io.ByteArrayOutputStream;

public class DangKyMail extends AppCompatActivity {

    TextView txtPhoneDk;
    ImageView imvback;
    EditText edtEmailEmail, edtNameEmail, edtPassEmail, edtRePassEmail;
    Button btnActDkEmail;
    CheckBox chkDieuKhoan;
    AccountDataBase ADB = new AccountDataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_mail);

        linkView();
        dangKyMail();
        transToPhone();
        back();




    }

    private void back() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(DangKyMail.this, DangNhap.class);
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


    private void dangKyMail() {

        btnActDkEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check dữ liệu
                String EmailEmail = edtEmailEmail.getText().toString().trim();
                String NameEmail = edtNameEmail.getText().toString().trim();
                String PassEmail = edtPassEmail.getText().toString().trim();
                String RePassEmail = edtRePassEmail.getText().toString().trim();
                if (EmailEmail.equals("")||NameEmail.equals("")|| PassEmail.equals("")||RePassEmail.equals("")){
                    Toast.makeText(DangKyMail.this, "Vui lòng điền hết các ô!", Toast.LENGTH_SHORT).show();

                }else{
                    if (chkDieuKhoan.isChecked()==false){
                        Toast.makeText(DangKyMail.this, "Bạn chưa đồng ý điều khoản!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (ADB.checkEmail(EmailEmail)){
                            Toast.makeText(DangKyMail.this, "Email đã có sẵn, vui lòng nhập Email khác!", Toast.LENGTH_SHORT).show();
                        }else {
                             if (RePassEmail.equals(PassEmail)) {
                    if (!ADB.checkUsername(NameEmail) ) {
                        Boolean insert =  ADB.insertData(NameEmail, PassEmail, NameEmail, "Blank", EmailEmail, "Blank", convertPhoto(R.drawable.unknownava));
                    if (insert ) {
                        Intent intentActDangKyEmail = new Intent(DangKyMail.this, DangNhap.class);
                        intentActDangKyEmail.putExtra("NamePhone_To_Login", NameEmail);

                        startActivity(intentActDangKyEmail);
                        Toast.makeText(DangKyMail.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();

                        }
                    }else{
                        Toast.makeText(DangKyMail.this, "Tài khoản đã có sẵn, vui lòng sử dụng tài khoản khác!", Toast.LENGTH_SHORT).show();
                }}else{
                    Toast.makeText(DangKyMail.this, "Nhập lại mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
                }
                }}}
            }}
        );
}


    private void transToPhone() {
        txtPhoneDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTranstoPhone = new Intent(DangKyMail.this, DangKyPhone.class);
                startActivity(intentTranstoPhone);
            }
        });
    }

    private void linkView() {
        txtPhoneDk = findViewById(R.id.txtPhoneDk);
        edtEmailEmail =findViewById(R.id.edtEmail);
        edtNameEmail = findViewById(R.id.edtNameEmail);
        edtPassEmail = findViewById(R.id.edtPassEmail);
        edtRePassEmail = findViewById(R.id.edtRePassEmail);
        btnActDkEmail = findViewById(R.id.btnActDkEmail);
        imvback = findViewById(R.id.back);
        chkDieuKhoan = findViewById(R.id.chkQuyDinhMail);
    }
}