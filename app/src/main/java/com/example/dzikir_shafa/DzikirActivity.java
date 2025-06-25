package com.example.dzikir_shafa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DzikirActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DzikirPagerAdapter pagerAdapter;
    private List<DzikirModel> dzikirList = new ArrayList<>();
    private String kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir);

        viewPager = findViewById(R.id.viewPagerDzikir);
        kategori = getIntent().getStringExtra("kategori");

        loadDataFromJson();
    }

    private void loadDataFromJson() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.dzikir);
            Reader reader = new InputStreamReader(inputStream);
            Gson gson = new Gson();

            DzikirModel[] data = gson.fromJson(reader, DzikirModel[].class);
            for (DzikirModel model : data) {
                if (model.getKategori().equals(kategori)) {
                    dzikirList.add(model);
                }
            }

            reader.close();


            if (!dzikirList.isEmpty()) {
                pagerAdapter = new DzikirPagerAdapter(getSupportFragmentManager(), dzikirList);
                viewPager.setAdapter(pagerAdapter);

//                PagerBullet pagerBullet = findViewById(R.id.pager_bullet);
//                pagerBullet.setViewPager(viewPager);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
