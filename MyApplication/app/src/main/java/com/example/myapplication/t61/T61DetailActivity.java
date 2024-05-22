package com.example.myapplication.t61;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class T61DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_t61_detail);
        //nhan du lieu tu listproduct chuyen sang
        Intent intent = getIntent();
        Product product = intent.getParcelableExtra("PRODUCT");
        //anh xa thanh phan len giao dien
        ImageView imgPro = findViewById(R.id.T6detailImg);
        TextView tvStyleIdPro = findViewById(R.id.T6DetailTVStyleID);
        TextView tvPricePro = findViewById(R.id.T6DetailTVPrice);
        TextView tvBrandPro = findViewById(R.id.T6DetailTVBrand);
        TextView tvInfoPro = findViewById(R.id.T6DetailTVAddInfo);
        //hien thi thong tin chi tiet cua sp
        if (product!=null) {
            //hien thi anh
            Picasso.get().load(product.getSearchImage()).into(imgPro);
            //hien thi text
            tvInfoPro.setText("Info: "+product.getAdditionalInfo());
            tvBrandPro.setText("Brand "+product.getBrand());
            tvPricePro.setText("Price: "+product.getPrice());
            tvStyleIdPro.setText("StyleID: "+product.getStyleId());
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}