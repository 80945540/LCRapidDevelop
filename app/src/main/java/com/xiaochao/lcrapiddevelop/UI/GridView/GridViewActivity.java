package com.xiaochao.lcrapiddevelop.UI.GridView;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiaochao.lcrapiddevelop.UI.Adapter.ListViewAdapter;
import com.xiaochao.lcrapiddevelop.Constant.Constant;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.MVP.Presenter.BookListPresent;
import com.xiaochao.lcrapiddevelop.MVP.View.BookListView;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;

import java.util.List;

public class GridViewActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener,BookListView {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeLayout;
    ProgressActivity progress;
    private Toolbar toolbar;
    private BaseQuickAdapter mQuickAdapter;
    private int PageIndex=1;
    private BookListPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        toolbar();
        initView();
        intiListener();
    }

    private void toolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void intiListener() {
        swipeLayout.setOnRefreshListener(this);
        mQuickAdapter.setOnLoadMoreListener(this);
        mQuickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(GridViewActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        progress = (ProgressActivity) findViewById(R.id.progress);
        //与Listview唯一的区别就是这里new GridLayoutManager(this,2) 数字代表列数
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setHasFixedSize(true);
        progress.showLoading();
        mQuickAdapter = new ListViewAdapter(R.layout.list_view_item_layout,null);
        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mQuickAdapter.openLoadMore(6,true);
        mRecyclerView.setAdapter(mQuickAdapter);
        present = new BookListPresent(this);
        present.LoadData("1",PageIndex,false);
    }

    @Override
    public void onRefresh() {
        PageIndex=1;
        present.LoadData("1",PageIndex,false);
    }

    @Override
    public void onLoadMoreRequested() {
        PageIndex++;
        present.LoadData("1",PageIndex,true);
    }

    /*
    * MVP状态
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
    public void newDatas(List<BookListDto> newsList) {
        //进入显示的初始数据或者下拉刷新显示的数据
        mQuickAdapter.setNewData(newsList);//新增数据
        mQuickAdapter.openLoadMore(10,true);//设置是否可以下拉加载  以及加载条数
        swipeLayout.setRefreshing(false);//刷新成功
    }

    @Override
    public void addDatas(List<BookListDto> addList) {
        mQuickAdapter.notifyDataChangedAfterLoadMore(addList, true);
    }

    @Override
    public void showLoadFailMsg() {
        progress.showError(getResources().getDrawable(R.mipmap.monkey_cry), Constant.ERROR_TITLE, Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.showLoading();
                PageIndex=1;
                present.LoadData("1",PageIndex,false);
            }
        });
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
        progress.showEmpty(getResources().getDrawable(R.mipmap.monkey_nodata),Constant.EMPTY_TITLE,Constant.EMPTY_CONTEXT);
    }
}
