package com.ismailhakkiaydin.customviewcase;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> mBgColor = new MutableLiveData<>();
    public MutableLiveData<String> mTextView = new MutableLiveData<>();
    public MutableLiveData<Integer> mTextSize = new MutableLiveData<>();
    public MutableLiveData<String> mTextColor = new MutableLiveData<>();


}
