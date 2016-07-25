# RapidDevelop-Android快速开发框架
 - 框架持续更新中
 - 目前主要针对列表显示方面的集成
 - 对本项目感兴趣的可以一起研究
 - 同时也欢迎大家的宝贵意见
 - 邮箱:80945540@qq.com
 - [下载APK](http://fir.im/LCRapidDevelop) 

--------
##功能说明
 - 网络请求及请求数据缓存
 - 下拉刷新 上拉加载 及自动加载
 - RecyclerView设配器
 - RecyclerView item加载动画
 - 页面状态统一管理 加载中  无数据  无网络
 - 图片显示与缓存 GIF图片显示
 - Tab+Fragment快速实现
--------

##效果图展示
<img src="/image/image1.png" style="width: 20%;">
<img src="/image/image2.png" style="width: 20%;">
<img src="/image/image3.png" style="width: 20%;">
<img src="/image/image4.png" style="width: 20%;">
<img src="/image/image5.png" style="width: 20%;">
<img src="/image/image6.png" style="width: 20%;">
<img src="/image/image7.png" style="width: 20%;">
<img src="/image/image8.png" style="width: 20%;">

--------------

##使用说明

导入 lcrapiddeveloplibrary 到项目

在 build.gradle 的 dependencies 添加:

    dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    ....
    compile project(':lcrapiddeveloplibrary')
    compile 'com.android.support:recyclerview-v7:23.4.0'
    compile 'com.github.bumptech.glide:glide:3.7.0'
    compile 'com.android.support:cardview-v7:23.4.0'
    }
 - recyclerview--->本框架使用recyclerview代替了原始的ListView及GridView  更加灵活和便捷
 - glide--->Google官方推荐的图片显示库(具备自动缓存功能 效率及内存完爆其他图片框架)
 - cardview-->卡片布局,Item使用卡片布局感觉比较漂亮,以及点击效果比较炫酷,推荐给大家学习下

导入之后呢就比较简单和粗暴了

    <android.support.v7.widget.RecyclerView
        android:id="@+id/rv_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </android.support.v7.widget.RecyclerView>

具体的相关功能请下载demo查看,比如下拉刷新,自动加载,滑动动画....

    switch (data.getType()){
                        case JsonData.DATA_LOAD_OK:
                            //新增自动加载的的数据
                            mQuickAdapter.notifyDataChangedAfterLoadMore(data.getT(), true);
                            break;
                        case JsonData.DATA_LOAD_NULL:
                            //所有数据加载完成后显示
                            mQuickAdapter.notifyDataChangedAfterLoadMore(false);
                            View view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) mRecyclerView.getParent(), false);
                            mQuickAdapter.addFooterView(view);
                            break;
                        case JsonData.DATA_REFRESH_OK:
                            //进入显示的初始数据或者下拉刷新显示的数据
                            mQuickAdapter.setNewData(data.getT());//新增数据
                            mQuickAdapter.openLoadMore(10,true);//设置是否可以下拉加载  以及加载条数
                            swipeLayout.setRefreshing(false);//刷新成功
                            progress.showContent();
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

-----------


##Adapter编写说明
###常见ListView以及GridView Adapter
    public class ListViewAdapter extends BaseQuickAdapter<UniversityListDto> {
    public ListViewAdapter(int layoutResId, List<UniversityListDto> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UniversityListDto item) {
        helper.setText(R.id.listview_tv_title,item.getCnName()).setText(R.id.listview_tv_content,"热度:"+item.getHits());
        Glide.with(mContext)
                .load(item.getLogo().getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.def_head)
                .transform(new GlideCircleTransform(mContext))
                .into((ImageView) helper.getView(R.id.listview_image_url));
    }

###分组ListView以及GridView Adapter

    public class SectionAdapter extends BaseSectionQuickAdapter<MySection> {
   
    public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
        super( layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final MySection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more,item.isMroe());
        helper.setOnClickListener(R.id.more,new OnItemChildClickListener());
    }


    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        UniversityListDto video = (UniversityListDto) item.t;
        helper.setText(R.id.listview_tv_title,video.getCnName()).setText(R.id.listview_tv_content,"热度:"+video.getHits());
        Glide.with(mContext)
                .load(video.getLogo().getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.def_head)
                .transform(new GlideCircleTransform(mContext))
                .into((ImageView) helper.getView(R.id.listview_image_url));
    }


###多布局ListView Adapter
    public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<ChatDto> {

    public MultipleItemQuickAdapter(Context context, List data) {
        super( data);
        addItemType(ChatDto.TEXT, R.layout.chat_text_layout);
        addItemType(ChatDto.IMG, R.layout.chat_img_layout);
        addItemType(ChatDto.IMGS, R.layout.chat_imgs_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatDto item) {
        switch (helper.getItemViewType()) {
            case ChatDto.TEXT:
                helper.setText(R.id.text_context, item.getTextContext());
                break;
            case ChatDto.IMG:
                Glide.with(mContext)
                        .load(item.getTextContext())
                        .crossFade()
                        .crossFade()
                        .placeholder(R.drawable.timg1)
                        .into((ImageView) helper.getView(R.id.img_imageview));
                break;
            case ChatDto.IMGS:
                Glide.with(mContext)
                        .load(item.getTextContext())
                        .crossFade()
                        .placeholder(R.drawable.timg)
                        .into((ImageView) helper.getView(R.id.imgs_imageview));
                helper.setText(R.id.imgs_textview, item.getTextContext());
                break;
        }
    }

