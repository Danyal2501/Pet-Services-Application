package com.example.pawsupapplication.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.pawsupapplication.R;

public class ReviewAdapter extends BaseAdapter {

    Context context;
    Object ReviewInfo[];
    LayoutInflater inflater;

    public ReviewAdapter(Context applicationContext, Object[] rInfo) {
        this.context = applicationContext;
        this.ReviewInfo = rInfo;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return ReviewInfo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.review_display, null);
        TextView rInfo = (TextView)view.findViewById(R.id.reviewText);
        rInfo.setText((String)ReviewInfo[i]);
        return view;
    }
}
