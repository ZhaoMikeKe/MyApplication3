package com.example.copyqqsmooth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SlideAdapter extends BaseAdapter implements View.OnClickListener {

    private List<String> dataList;
    private Context context;
    private LayoutInflater inflater;

    public SlideAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            View content = inflater.inflate(R.layout.layout, null);
            View menu = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder(content, menu);
            SlideItem slideItem = new SlideItem(context);
            slideItem.setContentView(content, menu);
            convertView = slideItem;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemTvDelete.setOnClickListener(this);
        holder.itemTvNoRead.setOnClickListener(this);
        holder.itemTvToTop.setOnClickListener(this);
        holder.name.setText(dataList.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView itemTvToTop;
        TextView itemTvNoRead;
        TextView itemTvDelete;
        TextView name;

        public ViewHolder(View center, View menu) {
            this.itemTvToTop = (TextView) menu.findViewById(R.id.button);
            this.itemTvNoRead = (TextView) menu.findViewById(R.id.button2);
            this.itemTvDelete = (TextView) menu.findViewById(R.id.button3);
            this.name = center.findViewById(R.id.textView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(context, "置顶了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(context, "标为未读", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(context, "删除啦", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}