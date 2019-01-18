package com.example.listpopup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListPopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListPopupWindow mListPop;
    private List<String> lists = new ArrayList<String>();
    Button tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        lists.add("one");
        lists.add("two");
        lists.add("three");
        mListPop = new ListPopupWindow(this);
        mListPop.setAdapter(new PopupWindowAdapter(this, lists));
        mListPop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListPop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListPop.setAnchorView(tv);//设置ListPopupWindow的锚点，即关联PopupWindow的显示位置和这个锚点
        mListPop.setModal(true);//设置是否是模式

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListPop.show();
            }
        });
        mListPop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                mListPop.dismiss();
            }
        });


    }


}
