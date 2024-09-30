package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // รับข้อมูลจาก Intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("productName");
        String productPrice = intent.getStringExtra("productPrice");
        String productImage = intent.getStringExtra("productImage");


        // ผูกข้อมูลกับวิวต่างๆ
        ImageView imageView = findViewById(R.id.detail_image);
        TextView nameTextView = findViewById(R.id.detail_name);
        TextView priceTextView = findViewById(R.id.detail_price);

        Button buyButton = findViewById(R.id.buy_button_detail);

        nameTextView.setText(productName);
        priceTextView.setText(productPrice);


        // โหลดรูปภาพ
        Glide.with(this).load(productImage).into(imageView);

        // ตั้งค่าปุ่ม "กดซื้อ"
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // แสดงข้อความแจ้งเตือน
                Toast.makeText(DetailActivity.this, "ซื้อสำเร็จ!", Toast.LENGTH_SHORT).show();

                // เปลี่ยนหน้าไปยัง MainActivity2
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
