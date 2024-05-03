package com.example.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.text.InputFilter;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.button);

        // تحديد الحد الأقصى لعدد الأحرف
        passwordEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});

        loginButton.setOnClickListener(view -> {
            String number = passwordEditText.getText().toString(); // الرقم الذي يدخله المستخدم
            String baseUrl = "https://imacscenter.org/masjid/"; // الرابط الأساسي

            // التحقق من أن الرقم يحتوي على 5 أرقام فقط
            if (number.length() == 5) {
                // تحويل الرقم إلى الصيغة المطلوبة
                StringBuilder formattedNumber = new StringBuilder(number);
                formattedNumber.insert(2, '.'); // إضافة النقطة بين الرقم الثاني والثالث
                baseUrl += formattedNumber + "/";

                // فتح الرابط الكامل
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(baseUrl));
                startActivity(intent);
            } else {
                // إذا كان الرقم غير صالح (أقل من 5 أرقام أو أكثر)، قم بعرض رسالة خطأ
                Toast.makeText(getApplicationContext(), "يرجى إدخال رقم مكون من 5 أرقام فقط", Toast.LENGTH_SHORT).show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            // فتح صفحة السياسة بالخصوصية
            String url = "https://imacscenter.org/main/privacy-policy/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }


}
//bruhhhhhhhd

