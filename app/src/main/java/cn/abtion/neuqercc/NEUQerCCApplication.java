package cn.abtion.neuqercc;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.abtion.neuqercc.account.activities.LoginActivity;
import cn.abtion.neuqercc.utils.CacheUtil;

/**
 * @author abtion.
 * @since 17/9/22 17:56.
 * email caiheng@hrsoft.net
 */

public class NEUQerCCApplication extends Application {
    private static NEUQerCCApplication instance;//实例对象
    private static List<Activity> activityList = new ArrayList<>();
    private static CacheUtil cacheUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /**
     * 缓存初始化
     */
    public CacheUtil getCacheUtil() {
        if (cacheUtil == null) {
            cacheUtil = CacheUtil.get(instance.getFilesDir());
        }
        return cacheUtil;
    }

    /**
     * 外部获取实例对象
     *
     * @return net.hrsoft.transparent_factory_manager.NEUQerCCApplication
     */
    public static NEUQerCCApplication getInstance() {
        return instance;
    }

    private static android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new android.app.Application.ActivityLifecycleCallbacks() {

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activityList.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            activityList.remove(activity);
        }
    };

    /**
     * 移除Activity
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /**
     * 清除所有Activity
     */
    public void removeAllActivity() {
        for (Activity activity : activityList) {
            if (activity != null && !activity.isFinishing())
                activity.finish();
        }
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        removeAllActivity();
        System.exit(0);
    }

    /**
     * 退出账户
     */
    public void exitAccount() {
        getCacheUtil().clear();
        removeAllActivity();
        Intent intent = new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
