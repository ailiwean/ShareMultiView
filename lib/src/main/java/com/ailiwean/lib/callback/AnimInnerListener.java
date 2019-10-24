package com.ailiwean.lib.callback;

import android.view.View;

import com.ailiwean.lib.delegate.ShareMultiDelegate;


/**
 * 该接口通过{@link ShareMultiDelegate}调用提供View,最后执行内部方法
 */
public interface AnimInnerListener {

    void enter(View pageView, boolean isExecute);

    void exit(View pageView, boolean isExecute);

}
