package com.xiaochao.lcrapiddevelop.UI.ListviewGrouping;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiaochao.lcrapiddevelop.UI.Adapter.SectionAdapter;
import com.xiaochao.lcrapiddevelop.Constant.Constant;
import com.xiaochao.lcrapiddevelop.Constant.JsonData;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.MVP.Presenter.SchoolListPresent;
import com.xiaochao.lcrapiddevelop.MVP.View.SchoolListView;
import com.xiaochao.lcrapiddevelop.UI.entity.MySection;
import com.xiaochao.lcrapiddevelop.UI.entity.UniversityListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;

import java.util.List;

public class ListviewGroupingActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener,SchoolListView {
    RecyclerView mRecyclerView;
    ProgressActivity progress;
    SwipeRefreshLayout swipeLayout;
    private Toolbar toolbar;
    private SectionAdapter mQuickAdapter;
    private int PageIndex=1;
    private SchoolListPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_grouping);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();
        initListener();
    }

    private void initView() {
        present = new SchoolListPresent(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        progress = (ProgressActivity) findViewById(R.id.progress);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mQuickAdapter = new SectionAdapter(R.layout.list_view_item_layout,R.layout.def_section_head,null);
        mQuickAdapter.setOnLoadMoreListener(this);
        mQuickAdapter.openLoadMore(4,true);
        mRecyclerView.setAdapter(mQuickAdapter);

        present.LoadData(PageIndex,4,false);
    }
    private void initListener() {
        swipeLayout.setOnRefreshListener(this);
        mQuickAdapter.setOnLoadMoreListener(this);

        mQuickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                try {
                    MySection mySection = (MySection) mQuickAdapter.getData().get(position);
                    if (!mySection.isHeader)
                        Toast.makeText(ListviewGroupingActivity.this,mySection.t.getCnName(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mQuickAdapter.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(ListviewGroupingActivity.this, "没有更多", Toast.LENGTH_LONG).show();
            }
        });
    }
    //下拉刷新
    @Override
    public void onRefresh() {
        PageIndex=1;
        present.LoadData(PageIndex,4,false);
    }
    //自动加载
    @Override
    public void onLoadMoreRequested() {
        PageIndex++;
        present.LoadData(PageIndex,4,true);
    }

    /*
    * 加载动画切换的状态栏代码
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_grouping, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings_AlphaIn:
                mQuickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                mRecyclerView.setAdapter(mQuickAdapter);
                return true;
            case R.id.action_settings_ScaleIn:
                mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                mRecyclerView.setAdapter(mQuickAdapter);
                return true;
            case R.id.action_settings_SlideInBottom:
                mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                mRecyclerView.setAdapter(mQuickAdapter);
                return true;
            case R.id.action_settings_SlideInLeft:
                mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                mRecyclerView.setAdapter(mQuickAdapter);
                return true;
            case R.id.action_settings_SlideInRight:
                mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                mRecyclerView.setAdapter(mQuickAdapter);
                return true;
            case R.id.action_settings_Custom:
                mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_CUSTOM);
                mRecyclerView.setAdapter(mQuickAdapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /*
    * MVP相关状态
    * */
    @Override
    public void showProgress() {
        progress.showLoading();
    }

    @Override
    public void hideProgress() {
        progress.showContent();
    }

    @Override
    public void newDatas(List<UniversityListDto> newsList) {
        //进入显示的初始数据或者下拉刷新显示的数据
        mQuickAdapter.setNewData(JsonData.getSampleData(newsList,PageIndex));//新增数据
        mQuickAdapter.openLoadMore(4,true);//设置是否可以下拉加载  以及加载条数
        swipeLayout.setRefreshing(false);//刷新成功
    }

    @Override
    public void addDatas(List<UniversityListDto> addList) {
        mQuickAdapter.notifyDataChangedAfterLoadMore(JsonData.getSampleData(addList,PageIndex), true);
    }

    @Override
    public void showLoadFailMsg() {
        progress.showEmpty(getResources().getDrawable(R.mipmap.monkey_nodata),Constant.EMPTY_TITLE,Constant.EMPTY_CONTEXT);
    }

    @Override
    public void showLoadCompleteAllData() {
        //所有数据加载完成后显示
        mQuickAdapter.notifyDataChangedAfterLoadMore(false);
        View view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) mRecyclerView.getParent(), false);
        mQuickAdapter.addFooterView(view);
    }

    @Override
    public void showNoData() {
        progress.showError(getResources().getDrawable(R.mipmap.monkey_cry), Constant.ERROR_TITLE, Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.showLoading();
                PageIndex=1;
                present.LoadData(PageIndex,4,false);
            }
        });
    }
}
