package com.example.onboardingscreen;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OnBoarding3Fragment extends Fragment {
    private Button btn_start;
    private View view;

    public OnBoarding3Fragment() {

    }


    public static OnBoarding3Fragment newInstance() {
        return new OnBoarding3Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout cho Fragment
        view = inflater.inflate(R.layout.fragment_on_boarding3, container, false);
        btn_start = view.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(v -> {
            if (getActivity() != null) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}