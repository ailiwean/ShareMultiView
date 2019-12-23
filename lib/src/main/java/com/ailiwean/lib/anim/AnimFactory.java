package com.ailiwean.lib.anim;

import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import java.util.Objects;

import static android.view.View.LAYER_TYPE_NONE;
import static android.view.View.LAYER_TYPE_SOFTWARE;

public class AnimFactory {

    private AnimHolder enterAnimHolder;

    private AnimHolder exitAnimHolder;

    public static class Holder {
        public static AnimFactory animFactory = new AnimFactory();
    }

    public static AnimFactory getInstance() {
        return Holder.animFactory;
    }

    public void bind(AnimHolder animHolder) {

        if (animHolder == null)
            return;

        if (animHolder.getEnter())
            enterAnimHolder = animHolder;
        else exitAnimHolder = animHolder;

        if (enterAnimHolder == null)
            return;

        if (exitAnimHolder == null)
            return;

        loop();
    }

    private void loop() {
        final AnimHolder temStart = enterAnimHolder;
        final AnimHolder temEnd = exitAnimHolder;

        exitAnimHolder = null;
        enterAnimHolder = null;

        //开启硬件加速
        temStart.getPageView().setLayerType(View.LAYER_TYPE_HARDWARE, null);
        temEnd.getPageView().setLayerType(View.LAYER_TYPE_HARDWARE, null);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(temStart.getAnimator(), temEnd.getAnimator());
        set.start();
    }
}
