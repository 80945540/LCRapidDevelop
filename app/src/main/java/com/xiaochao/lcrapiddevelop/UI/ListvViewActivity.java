package com.xiaochao.lcrapiddevelop.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiaochao.lcrapiddevelop.Adapter.ListViewAdapter;
import com.xiaochao.lcrapiddevelop.Constant.Constant;
import com.xiaochao.lcrapiddevelop.Data.HttpData.HttpData;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.entity.UniversityListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.container.AcFunHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.AliHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.DefaultHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.MeituanHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.RotationHeader;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;
import com.xiaochao.lcrapiddeveloplibrary.widget.SpringView;

import java.util.List;

import rx.Observer;

public class ListvViewActivity extends AppCompatActivity implements BaseQuickAdapter.RequestLoadMoreListener,SpringView.OnFreshListener {

    RecyclerView mRecyclerView;
    ProgressActivity progress;
    private Toolbar toolbar;
    private BaseQuickAdapter mQuickAdapter;
    private int PageIndex=1;
    private SpringView springView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listv_view);
        toolBar();
        initView();
        initListener();
    }

    private void toolBar() {
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

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        springView = (SpringView) findViewById(R.id.springview);
        //设置下拉刷新监听
        springView.setListener(this);
        //设置下拉刷新样式
        springView.setHeader(new RotationHeader(this));
        //springView.setFooter(new RotationFooter(this));mRecyclerView内部集成的自动加载  上啦加载用不上   在其他View使用
        progress = (ProgressActivity) findViewById(R.id.progress);
        //设置RecyclerView的显示模式  当前List模式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //如果Item高度固定  增加该属性能够提高效率
        mRecyclerView.setHasFixedSize(true);
        //设置页面为加载中..
        progress.showLoading();
        //设置适配器
        mQuickAdapter = new ListViewAdapter(R.layout.list_view_item_layout,null);
        //设置加载动画
        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //设置是否自动加载以及加载个数
        mQuickAdapter.openLoadMore(6,true);
        //将适配器添加到RecyclerView
        mRecyclerView.setAdapter(mQuickAdapter);
        //请求网络数据
        initdate(PageIndex,false);
    }
    private void initListener() {
        //设置自动加载监听
        mQuickAdapter.setOnLoadMoreListener(this);

        mQuickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ListvViewActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });
        mQuickAdapter.setOnRecyclerViewItemLongClickListener(new BaseQuickAdapter.OnRecyclerViewItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, int position) {
                Toast.makeText(ListvViewActivity.this, "长按了"+position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
   //自动加载
    @Override
    public void onLoadMoreRequested() {
        PageIndex++;
        initdate(PageIndex,true);
    }
    public void initdate(int PageIndex,final Boolean isJz){
        //获取数据 网络请求使用 retrofit rxjava okhttp
        HttpData.getInstance().HttpDataToSchoolList(PageIndex, 12, new Observer<List<UniversityListDto>>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                //设置页面为加载错误
                toError();
            }

            @Override
            public void onNext(List<UniversityListDto> universityListDtos) {
                if(isJz){
                    if(universityListDtos.size()==0){
                        //所有数据加载完成后显示
                        mQuickAdapter.notifyDataChangedAfterLoadMore(false);
                        View view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) mRecyclerView.getParent(), false);
                        mQuickAdapter.addFooterView(view);
                    }else{
                        //新增自动加载的的数据
                        mQuickAdapter.notifyDataChangedAfterLoadMore(universityListDtos, true);
                    }
                }else{
                    if(universityListDtos.size()==0){
                        //设置页面为无数据
                        toEmpty();
                    }else{
                        //进入显示的初始数据或者下拉刷新显示的数据
                        mQuickAdapter.setNewData(universityListDtos);//新增数据
                        mQuickAdapter.openLoadMore(10,true);//设置是否可以下拉加载  以及加载条数
                        springView.onFinishFreshAndLoad();//刷新完成
                        progress.showContent();
                    }
                }
            }
        });
    }
    //设置加载错误页显示
    public void toError(){
        try {
            mQuickAdapter.notifyDataChangedAfterLoadMore(false);
            View view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) mRecyclerView.getParent(), false);
            mQuickAdapter.addFooterView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        progress.showError(getResources().getDrawable(R.mipmap.monkey_cry), Constant.ERROR_TITLE, Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.showLoading();
                initdate(1,false);
            }
        });
    }
    //设置无数据页显示
    public void toEmpty(){
        progress.showEmpty(getResources().getDrawable(R.mipmap.monkey_cry),Constant.EMPTY_TITLE,Constant.EMPTY_CONTEXT);
    }
    //下拉刷新
    @Override
    public void onRefresh() {
        PageIndex=1;
        initdate(PageIndex,false);
    }
    //上啦加载  mRecyclerView内部集成的自动加载  上啦加载用不上   在其他View使用
    @Override
    public void onLoadmore() {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }
    private int[] pullAnimSrcs = new int[]{R.drawable.mt_pull,R.drawable.mt_pull01,R.drawable.mt_pull02,R.drawable.mt_pull03,R.drawable.mt_pull04,R.drawable.mt_pull05};
    private int[] refreshAnimSrcs = new int[]{R.drawable.mt_refreshing01,R.drawable.mt_refreshing02,R.drawable.mt_refreshing03,R.drawable.mt_refreshing04,R.drawable.mt_refreshing05,R.drawable.mt_refreshing06};
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings_AcFun:
                springView.setType(SpringView.Type.OVERLAP);
                springView.setHeader(new AcFunHeader(this,R.mipmap.acfun_header));
                return true;
            case R.id.action_settings_Ali:
                springView.setType(SpringView.Type.FOLLOW);
                springView.setHeader(new AliHeader(this,R.mipmap.ali,true));   //参数为：logo图片资源，是否显示文字
                return true;
            case R.id.action_settings_Default:
                springView.setType(SpringView.Type.FOLLOW);
                springView.setHeader(new DefaultHeader(this));
                return true;
            case R.id.action_settings_Meituan:
                springView.setType(SpringView.Type.FOLLOW);
                springView.setHeader(new MeituanHeader(this,pullAnimSrcs,refreshAnimSrcs));
                return true;
            case R.id.action_settings_Rotation:
                springView.setType(SpringView.Type.OVERLAP);
                springView.setHeader(new RotationHeader(this));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
