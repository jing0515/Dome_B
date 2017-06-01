package com.bawei.lvwenjing.dome_b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by muhanxi on 17/4/11.
 */

public class XListAdapter extends BaseAdapter {

    private List lists;
    private MainActivity context;
    public XListAdapter(MainActivity context, List list){
        this.context = context;
        this.lists = list;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null ;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.test_health_adapter,null);

            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.left_image);
            viewHolder.textViewDescription = (TextView) convertView.findViewById(R.id.test_healthtv);
            viewHolder.textViewTime = (TextView) convertView.findViewById(R.id.test_healthtv_timer);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textViewDescription.setText(lists.get(position).toString());




        return convertView;
    }


    static class ViewHolder {

        ImageView imageView;
        TextView textViewDescription;
        TextView textViewTime;

    }

}
