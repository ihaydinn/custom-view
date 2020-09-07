package com.ismailhakkiaydin.customviewcase;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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

        String text = value.getString(R.styleable.TextViewCV_cv_sb_text);
        if (text != null){
            setText(text);
        }


        value.recycle();
    }


    public void isClicked(){
        mLinearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        mTextView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        mTextView.setText("Beni Tıkladın!");
        mTextView.setTextSize(25);
    }

    public void setText(String text) {
        mTextView.setText(text);
    }
    /*
    public String getText(){
        return mTextView.getText().toString();
    }
*/

}
