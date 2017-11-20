package cn.abtion.neuqercc.home.activities;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.reflect.Field;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.base.activities.ToolBarActivity;
import cn.abtion.neuqercc.common.Config;
import cn.abtion.neuqercc.home.adapters.CompetitionViewPagerAdapter;
import cn.abtion.neuqercc.main.MainActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author abtion.
 * @since 17/9/30 22:07.
 * email caiheng@hrsoft.net.
 */

public class CompetitionActivity extends ToolBarActivity{

    @BindView(R.id.table_header_navigation)
    TabLayout headerTitleTable;
    @BindView(R.id.viewpager_body)
    ViewPager competitionViewPager;


    @Override
    protected  int getLayoutId(){
        return R.layout.activity_competion;
    }


    @Override
    protected  void initVariable(){

        CompetitionViewPagerAdapter competitionPagerAdapter =new CompetitionViewPagerAdapter(getSupportFragmentManager());
        competitionViewPager.setAdapter(competitionPagerAdapter);
        //tabLayout和ViewPager联动
        headerTitleTable.setupWithViewPager(competitionViewPager);
    }

    @Override
    protected void initView() {

        this.setActivityTitle(getString(R.string.title_competition));

        //修改tab指示器长度
        setIndicator(headerTitleTable,Config.TAB_INDICATOR_WIDTH,Config.TAB_INDICATOR_WIDTH);
    }

    @Override
    protected  void loadData(){

    }

    /**
     * 寻找队伍按钮点击事件
     */

    @OnClick(R.id.btn_search)
    public void onBtnSearchClicked(){

        MainActivity.start(this,Config.FLAG_TEAM);
        finish();
    }


    /**
     * 修改指示器长度的方法
     */
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

}
