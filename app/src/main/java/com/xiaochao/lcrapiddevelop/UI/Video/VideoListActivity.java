package com.xiaochao.lcrapiddevelop.UI.Video;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiaochao.lcrapiddevelop.MVP.Presenter.VideoListPresent;
import com.xiaochao.lcrapiddevelop.MVP.View.VideoListView;
import com.xiaochao.lcrapiddevelop.UI.Adapter.VideoLisViewAdapter;
import com.xiaochao.lcrapiddevelop.Constant.Constant;
import com.xiaochao.lcrapiddevelop.Data.HttpData.HttpData;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.UI.entity.VideoListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.container.RotationHeader;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;
import com.xiaochao.lcrapiddeveloplibrary.widget.SpringView;

import java.util.List;

import rx.Observer;

public class VideoListActivity extends AppCompatActivity implements BaseQuickAdapter.RequestLoadMoreListener,SpringView.OnFreshListener,VideoListView{

    Toolbar videolisttoolbar;
    RecyclerView videolistrvlist;
    SpringView videolistspringview;
    ProgressActivity videolistprogress;
    private VideoLisViewAdapter mQuickAdapter;
    private VideoListPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        initView();
        init();
    }
    private void initView() {
        videolisttoolbar = (Toolbar) findViewById(R.id.video_list_toolbar);
        videolisttoolbar.setTitle("List列表视频播放");
        setSupportActionBar(videolisttoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        videolisttoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        videolistrvlist = (RecyclerView) findViewById(R.id.video_list_rv_list);
        videolistspringview = (SpringView) findViewById(R.id.video_list_springview);
        videolistprogress = (ProgressActivity) findViewById(R.id.video_list_progress);

    }
    private void init() {
        videolistspringview.setListener(this);
        videolistspringview.setHeader(new RotationHeader(this));
        //设置RecyclerView的显示模式  当前List模式
        videolistrvlist.setLayoutManager(new LinearLayoutManager(this));
        //如果Item高度固定  增加该属性能够提高效率
        videolistrvlist.setHasFixedSize(true);
        //设置页面为加载中..
        videolistprogress.showLoading();
        //设置适配器
        mQuickAdapter = new VideoLisViewAdapter(R.layout.video_list_view_item_layout,null);
        //设置加载动画
        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //设置是否自动加载以及加载个数
        mQuickAdapter.openLoadMore(6,true);
        //将适配器添加到RecyclerView
        videolistrvlist.setAdapter(mQuickAdapter);
        //设置自动加载监听
        mQuickAdapter.setOnLoadMoreListener(this);

        mQuickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(VideoListActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });
        //请求网络数据
        present = new VideoListPresent(this);
        present.LoadData();
    }
    @Override
    public void onRefresh() {
        present.LoadData();
    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void onLoadMoreRequested() {

    }
    /*
    * MVP状态
    * */
    @Override
    public void showProgress() {
        videolistprogress.showLoading();
    }

    @Override
    public void hideProgress() {
        videolistprogress.showContent();
    }

    @Override
    public void newDatas(List<VideoListDto> newsList) {
        //进入显示的初始数据或者下拉刷新显示的数据
        mQuickAdapter.setNewData(newsList);//新增数据
        mQuickAdapter.openLoadMore(6,true);//设置是否可以下拉加载  以及加载条数
        videolistspringview.onFinishFreshAndLoad();//刷新完成
    }
    @Override
    public void showLoadFailMsg() {
        videolistprogress.showError(getResources().getDrawable(R.mipmap.monkey_cry), Constant.ERROR_TITLE, Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videolistprogress.showLoading();
                present.LoadData();
            }
        });
    }

    @Override
    public void showNoData() {
        videolistprogress.showEmpty(getResources().getDrawable(R.mipmap.monkey_nodata),Constant.EMPTY_TITLE,Constant.EMPTY_CONTEXT);
    }
}
