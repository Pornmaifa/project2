package com.example.project2;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project2.model.Product;

public class MainActivity2 extends AppCompatActivity {

    private List<Product> productList;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // สร้างรายการสินค้า
        productList = new ArrayList<>();
        productList.add(new Product("ชุดกระโปรงลายตาราง", "299 บาท", "https://i.pinimg.com/564x/1a/82/ae/1a82ae4ab232450424bf37bff0774aca.jpg"));
        productList.add(new Product("ชุดเอี๊ยมกระโปรงแดง", "350 บาท", "https://i.pinimg.com/736x/93/fb/25/93fb2512a48368caa7c26f7d299ae7ea.jpg"));
        productList.add(new Product("ชุดเอี๊ยมกระโปรงชมพู", "550 บาท", "https://i.pinimg.com/564x/3d/48/cc/3d48ccd0d584b8a6ea93a3278c490789.jpg"));
        productList.add(new Product("ชุดเอี๊ยมกางเกงยีน", "490 บาท", "https://i.pinimg.com/564x/f6/20/56/f6205695ed631b1ba790471b14f7558e.jpg"));
        productList.add(new Product("ชุดนอน", "200 บาท", "https://i.pinimg.com/564x/41/f5/f9/41f5f91aa2742ae0eaa5af508ad12603.jpg"));
        productList.add(new Product("ชุดกระโปรงดำ", "350 บาท", "https://i.pinimg.com/736x/a1/ef/a2/a1efa2bcd8ed8207ee3c3874dc7a813e.jpg"));
        productList.add(new Product("ชุดกระโปรงเหลือง", "250 บาท", "https://i.pinimg.com/564x/2a/e7/b0/2ae7b0de7c0ddb722333f454a035d405.jpg"));
        productList.add(new Product("ชุดกระโปรงขาว", "200 บาท", "https://i.pinimg.com/564x/04/96/46/049646f7636ff49d7334b3e68a6bb726.jpg"));
        productList.add(new Product("ชุดแยก เสื้อ+กระโปรง", "300 บาท", "https://i.pinimg.com/564x/46/ca/00/46ca00aaf098330647174aabee7aa71c.jpg"));

        // ตั้งค่า Adapter
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        // ค้นหา SearchView
        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
    }

    // ฟังก์ชันในการกรองรายการสินค้าตามข้อความที่ค้นหา
    private void filter(String text) {
        List<Product> filteredList = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}
