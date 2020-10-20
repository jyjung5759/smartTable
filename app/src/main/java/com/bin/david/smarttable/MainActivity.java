package com.bin.david.smarttable;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.bin.david.smarttable.adapter.ItemAdapter;
import com.bin.david.smarttable.bean.MainItem;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<MainItem> items = new ArrayList<>();
        items.add(new MainItem(TableListActivity.class,"TableList - 测试手势冲突"));
        items.add(new MainItem(ParseModeActivity.class,"ParseMode - 解析模式"));
        items.add(new MainItem(AnnotationModeActivity.class,"AnnotationMode - 注解模式"));
        items.add(new MainItem(PagerModeActivity.class,"PagerMode - 分页模式"));
        items.add(new MainItem(ArrayColumnModeActivity.class,"ArrayColumnMode - 数组List转列"));
        items.add(new MainItem(RefreshActivity.class,"Refresh - 刷新加载加载更多"));
        items.add(new MainItem(MultParseModeActivity.class,"MultiParseMode - 多行解析模式"));
        items.add(new MainItem(AlignActivity.class,"Align - 文字Align测试"));
        items.add(new MainItem(ManyActivity.class,"Many - 测试大量列"));
        items.add(new MainItem(MinModeActivity.class,"MinMode - 设置表格最小宽度"));
        items.add(new MainItem(GridModeActivity.class,"GridMode - 网格配置"));

//        items.add(new MainItem(NetHttpActivity.class,"NetHttp - 网络模式"));
//        items.add(new MainItem(ArrayModeActivity.class,"ArrayMode - 数组模式1(日程表)"));
//        items.add(new MainItem(DesktopModeActivity.class,"DesktopMode - 课桌"));
//        items.add(new MainItem(SeatModeActivity.class,"数组模式2(选座)"));
//        items.add(new MainItem(FormModeActivity.class,"FormMode - 表单模式"));
//        items.add(new MainItem(SeatModeActivity.class,"课程表"));
//        items.add(new MainItem(JXLExcelModeActivity.class,"JXL Excel"));
//        items.add(new MainItem(POIExcelModeActivity.class,"POI Excel"));
//        items.add(new MainItem(ChoiceExcelActivity.class,"Choice Excel"));
//        items.add(new MainItem(MapModeActivity.class,"MapMode - Json数据转表格"));
//        items.add(new MainItem(MergeModeActivity.class,"MergeMode - 自动合并单元"));
//        items.add(new MainItem(WelcomeActivity.class,"Welcome - 表格动画") );
//        items.add(new MainItem(AvatorModeActivity.class,"AvatorMode - 头像（高级）"));

        ItemAdapter itemAdapter = new ItemAdapter(items);
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.openLoadAnimation();
        itemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MainItem mainItem = (MainItem) adapter.getData().get(position);
                Intent i = new Intent(MainActivity.this,mainItem.clazz);
                startActivity(i);
            }
        });
    }



}
