package com.ismailhakkiaydin.customviewcase;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<Boolean> mBackgroundIsVisible = new MutableLiveData<>();
    public MutableLiveData<String> mTextView = new MutableLiveData<>();


}
