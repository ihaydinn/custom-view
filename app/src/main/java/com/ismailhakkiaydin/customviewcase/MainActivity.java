package com.ismailhakkiaydin.customviewcase;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.ismailhakkiaydin.customviewcase.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        activityMainBinding.setViewModel(mainViewModel);
        activityMainBinding.setLifecycleOwner(this);

        init(activityMainBinding.customTextView);

    }

    public void init(TextViewCV textViewCV) {
        activityMainBinding.button.setOnClickListener(v -> {
            Random rnd = new Random();
            int number = rnd.nextInt(4);
            String[] bgColorArray = {"#FF1212", "#1251FF", "#125212", "#651200"};
            String[] textColorArray = {"#FF4DD0E1", "#FFFFF176", "#FF81C784", "#003218"};

            textViewCV.setTextBgColor(bgColorArray[number]);
            textViewCV.setText("Beni Tıkladın..");
            textViewCV.setTextColor(textColorArray[number]);
            textViewCV.setTextSize(32);
        });
    }


}
