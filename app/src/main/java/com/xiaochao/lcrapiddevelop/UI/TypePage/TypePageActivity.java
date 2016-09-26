package com.xiaochao.lcrapiddevelop.UI.TypePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xiaochao.lcrapiddevelop.Constant.Constant;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddeveloplibrary.container.AcFunHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.AliHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.DefaultHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.MeituanHeader;
import com.xiaochao.lcrapiddeveloplibrary.container.RotationHeader;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;
import com.xiaochao.lcrapiddeveloplibrary.widget.SpringView;

public class TypePageActivity extends AppCompatActivity {

    private ProgressActivity typePageProgress;
    private Toolbar typePageToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_page);
        typePageToolbar = (Toolbar) findViewById(R.id.type_page_toolbar);
        typePageProgress = (ProgressActivity) findViewById(R.id.type_page_progress);
        setSupportActionBar(typePageToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        typePageToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        typePageProgress.showLoading();
    }
    /*
    * 菜单栏 修改器下拉刷新模式
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_type, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_type_loding:
                typePageProgress.showLoading();
                return true;
            case R.id.action_type_data:
                typePageProgress.showContent();
                return true;
            case R.id.action_type_no_data:
                typePageProgress.showEmpty(getResources().getDrawable(R.mipmap.monkey_nodata),Constant.EMPTY_TITLE,Constant.EMPTY_CONTEXT);
                return true;
            case R.id.action_type_error:
                //设置加载错误页显示
                typePageProgress.showError(getResources().getDrawable(R.mipmap.monkey_cry), Constant.ERROR_TITLE, Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        typePageProgress.showLoading();
                    }
                });
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
