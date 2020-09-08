package com.ismailhakkiaydin.customviewcase;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextViewCV extends FrameLayout {

    private Context mContext;

    private LinearLayout mLinearLayout;
    private TextView mTextView;
    private ColorChangeListener mColorChangeListener;


    public TextViewCV(@NonNull Context context) {
        super(context);
    }

    public TextViewCV(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view_textview, this);

        TypedArray value = context.obtainStyledAttributes(attrs, R.styleable.TextViewCV, 0, 0);

        mLinearLayout = view.findViewById(R.id.linearLayout);
        mTextView = view.findViewById(R.id.textView);

        value.recycle();
    }


    public String getText() {
        return mTextView.getText().toString();
    }

    public void setText(String text) {
        mTextView.setText(text);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        mTextView.addTextChangedListener(textWatcher);
    }


    public String getTextBgColor() {
        ColorDrawable cd = (ColorDrawable) mTextView.getBackground();
        if (cd == null) {
            return "";
        }
        int color = cd.getColor();

        return Integer.toHexString(color);
    }

    public void setTextBgColor(String color) {
        if (color != null) {
            if (!color.contains("#")) {
                color = "#" + color;
            }
            mTextView.setBackgroundColor(Color.parseColor(color));
        }

        if (mColorChangeListener != null) {
            mColorChangeListener.onColorChange();
        }
    }


    public void setColorChangeListener(ColorChangeListener listener) {
        mColorChangeListener = listener;
    }

    interface ColorChangeListener {
        void onColorChange();
    }

}
