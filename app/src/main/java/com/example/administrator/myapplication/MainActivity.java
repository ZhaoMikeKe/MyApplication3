package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.switch1)
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv, R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
                break;
            case R.id.button:
                break;
        }
    }
}
