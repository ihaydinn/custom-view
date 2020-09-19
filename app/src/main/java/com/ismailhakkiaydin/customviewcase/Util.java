package com.ismailhakkiaydin.customviewcase;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class Util {

    @BindingAdapter("textSize")
    public static void setTextSize(TextViewCV textViewCV, int size) {
        if (textViewCV.getTextSize() != size){
            textViewCV.setTextSize(size);
        }
    }


    @InverseBindingAdapter(attribute = "textSize")
    public static int getTextSize(TextViewCV textViewCV) {
        return textViewCV.getTextSize();
    }

    @BindingAdapter("textColor")
    public static void setTextColor(TextViewCV textViewCV, String color) {
        if (!textViewCV.getTextColor().equals(color)) {
            textViewCV.setTextColor(color);
        }
    }

    @InverseBindingAdapter(attribute = "textColor")
    public static String getTextColor(TextViewCV textViewCV) {
        return textViewCV.getTextColor();
    }



    @BindingAdapter("text")
    public static void setText(TextViewCV textViewCV, String text) {
        if (!textViewCV.getText().equals(text))
            textViewCV.setText(text);
    }

    @InverseBindingAdapter(attribute = "text")
    public static String getText(TextViewCV textViewCV) {
        return textViewCV.getText();
    }



    @BindingAdapter(value = "textAttrChanged")
    public static void setListener(TextViewCV textViewCV, final InverseBindingListener listener) {
        if (listener != null) {
            textViewCV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    listener.onChange();
                }
            });
        }
    }

    @BindingAdapter(value = "textColorAttrChanged")
    public static void setTextColorListener(TextViewCV textViewCV, final InverseBindingListener listener) {
        if (listener != null) {
            textViewCV.setTextColorChangeListener(() -> {
                listener.onChange();
            });
        }

    }

    @BindingAdapter(value = "textSizeAttrChanged")
    public static void setTextSizeListener(TextViewCV textViewCV, final InverseBindingListener listener) {
        if (listener != null) {
            textViewCV.setTextSizeChangeListener(() -> {
                listener.onChange();
            });
        }
    }

}
