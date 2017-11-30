package cn.abtion.neuqercc.base.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import cn.abtion.neuqercc.R;

/**
 * super activity for toolbar activity.
 * @author abtion.
 * @since 17/9/22 17:47.
 * email caiheng@hrsoft.net
 */

public abstract class ToolBarActivity extends BaseActivity {

    /** activity 页面Toolbar */
    private Toolbar toolbar;
    @BindView(R.id.txt_toolbar_title)
    protected TextView toolBarTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getToolbarView());
        init();
    }

    /**
     * 获取带toolbar的基类页面View
     *
     * @return View
     */
    private View getToolbarView() {
        LayoutInflater inflater = getLayoutInflater();
        RelativeLayout viewRoot = (RelativeLayout) inflater.inflate(R.layout.view_toolbar_base, null);
        FrameLayout viewContainer = (FrameLayout) viewRoot.findViewById(R.id.view_container);
        viewContainer.addView(inflater.inflate(getLayoutId(), null));
        initToolbar(viewRoot);
        return viewRoot;
    }

    /**
     * 初始化设置toolbar.
     *
     * @param root 页面rootView
     */
    private void initToolbar(View root) {
        toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackBtnOnclick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 获取当前页面的toolbar.
     *
     * @return toolbar
     */
    protected Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * 设置activity 页面标题
     *
     * @param charSequence 页面标题
     */
    protected void setActivityTitle(CharSequence charSequence) {
        if (toolbar != null) {
            //toolbar.setTitle(charSequence);
            //toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolBarTitle.setText(charSequence);
            toolBarTitle.setTextColor(getResources().getColor(R.color.white));
        }
    }

    /**
     * Toolbar返回按钮的监听事件
     */
    protected void onBackBtnOnclick() {
        this.finish();
    }
}
