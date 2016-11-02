package com.xiaochao.lcrapiddevelop.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.xiaochao.lcrapiddevelop.UI.Adapter.MainAdapter;
import com.xiaochao.lcrapiddevelop.Constant.Data;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.UI.ChatLayout.ChatLayoutActivity;
import com.xiaochao.lcrapiddevelop.UI.GridView.GridViewActivity;
import com.xiaochao.lcrapiddevelop.UI.ListvView.ListvViewActivity;
import com.xiaochao.lcrapiddevelop.UI.ListviewGrouping.ListviewGroupingActivity;
import com.xiaochao.lcrapiddevelop.UI.Tab.TabActivity;
import com.xiaochao.lcrapiddevelop.UI.TypePage.TypePageActivity;
import com.xiaochao.lcrapiddevelop.UI.Video.VideoListActivity;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private BaseQuickAdapter homeAdapter;
    private Toolbar activityToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }
    private void initView() {
        activityToolbar = (Toolbar) findViewById(R.id.activityToolbar);
        setSupportActionBar(activityToolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        //设置RecyclerView的显示模式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        homeAdapter = new MainAdapter( R.layout.main_item_layout, Data.getData());
        //设置加载动画
        homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //将适配器添加到RecyclerView
        mRecyclerView.setAdapter(homeAdapter);
    }
    private void initListener() {
        homeAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            private Intent intent;
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        BookListDto bookListDto=null;
                        Toast.makeText(MainActivity.this, bookListDto.getBookName(), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,TypePageActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,ListvViewActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this,ListviewGroupingActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this,GridViewActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this,ChatLayoutActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this,TabActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this,VideoListActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_share:
                Uri uri = Uri.parse("https://github.com/80945540/LCRapidDevelop");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
