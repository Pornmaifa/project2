package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project2.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private List<Product> productList;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        productList.add(new Product("เสื้อฮู้ด", "590 บาท", "https://inwfile.com/s-a/lpxfky.jpg"));
        productList.add(new Product("ชุด กระโปรง+เสื้อคลุม ", "789 บาท", "https://i.pinimg.com/736x/50/90/97/50909789ac74fc784d84043b63bb7e32.jpg"));
        productList.add(new Product("ชุดเดรส", "450 บาท", "https://i.pinimg.com/736x/fd/79/c7/fd79c7fe2117610ff5f60e1db0441037.jpg"));
        productList.add(new Product("เสื้อเปิดไหล่", "290 บาท", "https://i.pinimg.com/736x/b9/2f/2f/b92f2fece23673e008cc7c211d8e3d93.jpg"));
        productList.add(new Product("เสื้อผูกโบว์", "250 บาท", "https://i.pinimg.com/736x/98/97/0e/98970ed37c6f19e72d8ac44acaa8e8e2.jpg"));
        productList.add(new Product("ชุดเดรสกระโปรง", "550 บาท", "https://i.pinimg.com/736x/17/a7/c2/17a7c2f496897fe09558e0077231fe79.jpg" ));
        productList.add(new Product("ชุดผ้ายีน+กระโปรง", "690 บาท", "https://i.pinimg.com/564x/3a/16/dc/3a16dc8d040f9d353c6439a6b9dbab93.jpg"));
        productList.add(new Product("ชุดเดรสผูกโบว์ยาว", "480 บาท", "https://i.pinimg.com/736x/ea/06/78/ea067867332726acf06b1e71380bb465.jpg"));
        productList.add(new Product("ชุดเดรสสีขาว", "680 บาท", "https://i.pinimg.com/736x/35/4a/57/354a572d730cd8da916cc9b44d6caa98.jpg"));

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        // ค้นหา SearchView
        SearchView searchView = findViewById(R.id.search_view2);
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