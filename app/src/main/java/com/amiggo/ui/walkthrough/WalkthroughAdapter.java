package com.amiggo.ui.walkthrough;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amiggo.R;

import javax.inject.Inject;

public class WalkthroughAdapter extends PagerAdapter {
    private final String[] titleArray, descArray;

    @Inject
    public WalkthroughAdapter(Context mContext) {
        titleArray = mContext.getResources().getStringArray(R.array.walkthrough_titles);
        descArray = mContext.getResources().getStringArray(R.array.walkthrough_desc);
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View convertView = LayoutInflater.from(container.getContext()).inflate(R.layout.item_walk_through, null);
        TextView textViewTitle = convertView.findViewById(R.id.text_view_title);
        TextView textViewDesc = convertView.findViewById(R.id.text_view_desc);
        textViewTitle.setText(titleArray[position]);
        textViewDesc.setText(descArray[position]);
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
         container.removeView((View) object);
    }
}
