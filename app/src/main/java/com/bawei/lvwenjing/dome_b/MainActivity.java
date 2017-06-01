
package com.bawei.lvwenjing.dome_b;

import android.app.Activity;
import android.os.Bundle;

import com.example.xlistview.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements XListView.IXListViewListener {

    private XListView xListView;

    List<String> list = new ArrayList<String>();


    XListAdapter adapter;

    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xListView = (XListView) findViewById(R.id.xlistview_id);
        adapter = new XListAdapter(this, list);
        generData(true, 0, 10);

        xListView.setPullRefreshEnable(true);
        xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(this);


    }


    private void generData(boolean type, int start, int end) {
        for (int i = start; i < end; i++) {
            list.add(i + "");
        }
        if (type == true) {
            xListView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


/**
 * 下拉刷新
 */

    @Override
    public void onRefresh() {
        list.clear();
        int count = list.size();
        adapter.notifyDataSetChanged();
        generData(true, count, count + 10);
        xListView.stopRefresh();
        xListView.setRefreshTime("刚刚");

    }


/**
 * 上啦加载更多
 */

    @Override
    public void onLoadMore() {
        int count = list.size();
        generData(true, count, count + 10);
        xListView.stopLoadMore();
    }
}



