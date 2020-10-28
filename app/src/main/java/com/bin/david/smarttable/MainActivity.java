package com.bin.david.smarttable;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.bin.david.smarttable.adapter.ItemAdapter;
import com.bin.david.smarttable.bean.MainItem;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<MainItem> items = new ArrayList<>();
//        items.add(new MainItem(TableListActivity.class,"TableList - 测试手势冲突"));
//        items.add(new MainItem(ManyActivity.class,"Many - 测试大量列"));

        items.add(new MainItem(TableListFragment.class,"TableList - 测试手势冲突"));
        items.add(new MainItem(ManyFragment.class,"Many - 测试大量列"));

        ItemAdapter itemAdapter = new ItemAdapter(items);
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.openLoadAnimation();
        itemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MainItem mainItem = (MainItem) adapter.getData().get(position);
//                Intent i = new Intent(MainActivity.this,mainItem.clazz);
//                startActivity(i);
                System.out.println("=== click_pos: " + position + ", sel_item: " + mainItem);
                replaceFragment(mainItem);
            }
        });
    }

    public void replaceFragment(MainItem fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.recyclerView, fragment);
        fragmentTransaction.commit();
    }


}
