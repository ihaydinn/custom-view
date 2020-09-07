package com.ismailhakkiaydin.customviewcase;

import androidx.databinding.BindingAdapter;

public class Util {
    @BindingAdapter("app:customText")
    public void customText(TextViewCV textViewCV, String text){
        textViewCV.setText(text);
    }

}
