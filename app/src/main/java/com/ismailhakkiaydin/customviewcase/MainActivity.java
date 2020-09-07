package com.ismailhakkiaydin.customviewcase;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.ismailhakkiaydin.customviewcase.databinding.ActivityMainBinding;

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

        mainViewModel.mTextView.observe(this, v->{
            Toast.makeText(this, v, Toast.LENGTH_LONG).show();

        });

    }

    public void init(TextViewCV textViewCV) {
        activityMainBinding.button.setOnClickListener(v -> {
            textViewCV.isClicked();
        });
    }


}
