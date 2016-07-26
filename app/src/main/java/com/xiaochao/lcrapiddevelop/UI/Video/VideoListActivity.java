package com.xiaochao.lcrapiddevelop.UI.Video;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiaochao.lcrapiddevelop.Adapter.VideoLisViewAdapter;
import com.xiaochao.lcrapiddevelop.Data.Constant;
import com.xiaochao.lcrapiddevelop.Data.DataInterface;
import com.xiaochao.lcrapiddevelop.Data.JsonData;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.entity.DataDto;
import com.xiaochao.lcrapiddevelop.entity.UniversityListDto;
import com.xiaochao.lcrapiddevelop.entity.VideoListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.container.RotationHeader;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;
import com.xiaochao.lcrapiddeveloplibrary.widget.SpringView;

import org.json.JSONObject;

public class VideoListActivity extends AppCompatActivity implements BaseQuickAdapter.RequestLoadMoreListener,SpringView.OnFreshListener{

    Toolbar videolisttoolbar;
    RecyclerView videolistrvlist;
    SpringView videolistspringview;
    ProgressActivity videolistprogress;
    private VideoLisViewAdapter mQuickAdapter;
    private int PageIndex=1;
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
        //springView.setFooter(new RotationFooter(this));mRecyclerView内部集成的自动加载  上啦加载用不上   在其他View使用
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
        initdate(PageIndex,false);
    }
    public void initdate(int PageIndex,final Boolean isJz){
        JsonData.initVideoDate(this, PageIndex,12, isJz, new DataInterface() {
            @Override
            public JSONObject onMySuccess(JSONObject response) {
                DataDto<VideoListDto> data= JsonData.httpVideoDate(response,isJz);
                switch (data.getType()){
                    case JsonData.DATA_LOAD_OK:
                        //新增自动加载的的数据
                        mQuickAdapter.notifyDataChangedAfterLoadMore(data.getT(), true);
                        break;
                    case JsonData.DATA_LOAD_NULL:
                        //所有数据加载完成后显示
                        mQuickAdapter.notifyDataChangedAfterLoadMore(false);
                        View view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) videolistrvlist.getParent(), false);
                        mQuickAdapter.addFooterView(view);
                        break;
                    case JsonData.DATA_REFRESH_OK:
                        //进入显示的初始数据或者下拉刷新显示的数据
                        mQuickAdapter.setNewData(data.getT());//新增数据
                        mQuickAdapter.openLoadMore(10,true);//设置是否可以下拉加载  以及加载条数
                        videolistspringview.onFinishFreshAndLoad();//刷新完成
                        videolistprogress.showContent();
                        break;
                    case JsonData.DATA_REFRESH_NULL:
                        //设置页面为无数据
                        toEmpty();
                        break;
                    case JsonData.DATA_ERROR:
                        //设置页面为加载错误
                        toError();
                        break;
                }
                return response;
            }
            @Override
            public void onMyError() {
                toEmpty();
            }
        });
    }
    public void toError(){
        try {
            mQuickAdapter.notifyDataChangedAfterLoadMore(false);
            View view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) videolistrvlist.getParent(), false);
            mQuickAdapter.addFooterView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        videolistprogress.showError(getResources().getDrawable(R.mipmap.monkey_cry), Constant.ERROR_TITLE, Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videolistprogress.showLoading();
                initdate(1,false);
            }
        });
    }
    public void toEmpty(){
        videolistprogress.showEmpty(getResources().getDrawable(R.mipmap.monkey_cry),Constant.EMPTY_TITLE,Constant.EMPTY_CONTEXT);
    }
    @Override
    public void onRefresh() {
        PageIndex=1;
        initdate(PageIndex,false);
    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void onLoadMoreRequested() {
        PageIndex++;
        initdate(PageIndex,true);
    }
}
