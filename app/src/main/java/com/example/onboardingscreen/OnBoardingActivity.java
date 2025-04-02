package com.example.onboardingscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class OnBoardingActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView tv_skip,tv_next;

    private ImageView img_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.view_pager);
        tv_skip = findViewById(R.id.tv_skip);
        tv_next = findViewById(R.id.tv_next);
        img_next = findViewById(R.id.img_next);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        // Xu ly su kien nut Skip --> Chuyen sang MainActivity
        tv_skip.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Xu ly su kien nut Next
        tv_next.setOnClickListener(v->{
            int currentItem = viewPager.getCurrentItem();
            if (currentItem < adapter.getItemCount() - 1) {
                viewPager.setCurrentItem(currentItem + 1);
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == adapter.getItemCount() - 1) {
                    tv_next.setVisibility(View.GONE);
                    tv_skip.setVisibility(View.GONE);
                    img_next.setVisibility(View.GONE);
                } else {
                    tv_next.setVisibility(View.VISIBLE);
                    tv_skip.setVisibility(View.VISIBLE);
                    img_next.setVisibility(View.VISIBLE);
                }
            }

        });
    }
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() > 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else {
            super.onBackPressed();
        }
    }
}