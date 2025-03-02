package com.example.onboardingscreen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    // Mảng lưu trữ các Fragment sẽ hiển thị trong ViewPager2
    private final Fragment[] fragments = new Fragment[] {
            new OnBoarding1Fragment(),
            new OnBoarding2Fragment(),
            new OnBoarding3Fragment()
    };

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    // Phương thức tạo Fragment tương ứng với vị trí (position) trong ViewPager2
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Kiểm tra position có hợp lệ (từ 0 đến fragments.length - 1)
        if (position >= 0 && position < fragments.length) {
            return fragments[position];
        }
        // Nếu position không hợp lệ, trả về Fragment đầu tiên để tránh lỗi
        return fragments[0];
    }

    // Phương thức trả về số lượng Fragment (số trang) trong ViewPager2
    @Override
    public int getItemCount() {
        return fragments.length;
    }
}