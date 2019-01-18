package com.example.listpopupwindow;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ArrayList<String> mData = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        mData.add("one");
        mData.add("one");
        mData.add("one");
        mData.add("two");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow() {
        //tvSetImg(chooseTime, R.mipmap.arrow_top);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.choose_pop, null);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        //一定要在代码中setBackgroundDrawable，不然点击外面popupWindow是不会dismiss的
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_popup_view));
        popupWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        //popupWindow.showAsDropDown(btn);
        popupWindow.setOnDismissListener(new PopupDismissListener());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_choose_pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChooseTimeAdapter adapter = new ChooseTimeAdapter(MainActivity.this, new ChooseTimeAdapter.MyItemClickListener() {
            @Override
            public void onClick(View view) {
                int tag = (int) view.getTag();

                popupWindow.dismiss();
            }
        }, mData);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 弹窗消失的时候让箭头换回来
     */
    class PopupDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            //tvSetImg(chooseTime, R.mipmap.arrow_down);
        }

    }

    /**
     * 设置textView右侧的图像
     *
     * @param textView
     * @param img
     */
    private void tvSetImg(TextView textView, int img) {
        Drawable nav_up = getResources().getDrawable(img);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        textView.setCompoundDrawables(null, null, nav_up, null);
    }
}
