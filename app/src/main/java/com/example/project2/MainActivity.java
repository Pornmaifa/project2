package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);


        String image1 = "https://scontent.fubp1-1.fna.fbcdn.net/v/t39.30808-6/290507053_5306984336033837_8520020106696703407_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=cc71e4&_nc_eui2=AeGXBi2a94R3MqParFiw0SLuGsog-ZwhMp8ayiD5nCEyn88ugQz8nXWUf6Yp3W6mAMzv459NjRfV-pW0tj-bemRP&_nc_ohc=EJw0pMEDIJEQ7kNvgGaAx91&_nc_ht=scontent.fubp1-1.fna&_nc_gid=AhhtHukaY4HZqTElow0gNP4&oh=00_AYD9T9f3Q6Xa6yS5fxMDKEooUxET1k5JYvs5wcEQabINyw&oe=66F9E51C";
        String image2 = "https://scontent.fubp1-1.fna.fbcdn.net/v/t39.30808-6/301460159_399732638964544_8853755893838899639_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeFel2hcaS77Hq6zvq7eA3DPug9NNKx86tm6D000rHzq2QQtHhNse_u17T5aiuA-T-J2faBbTTW6g9cs76Hhone4&_nc_ohc=-WQGO2UvOQ4Q7kNvgEZr_K2&_nc_ht=scontent.fubp1-1.fna&_nc_gid=A8sAE0WarJ_c-UxadtkFdCT&oh=00_AYB7w7AhGHRoAoMV3FdiGGHa9OQ8-R6e1I4_0cJmXzbgDA&oe=66FA0600";
        String image3 = "https://img.kapook.com/u/pimor/baby2/12_6.jpg";
        Glide.with(this)
                .load(image1)
                .into(imageView);

        Glide.with(this)
                .load(image2)
                .into(imageView2);

        Glide.with(this)
                .load(image3)
                .into(imageView3);

        //ปุ่ม
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent2);
            }
        });

    }
}