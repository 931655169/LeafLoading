package com.example.administrator.leafloading;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoadingDialog extends Dialog {
    private Context mContext;
    private int mProgress=0;
    private static final int REFRESH_PROGRESS = 0x10;
    @BindView(R.id.leafLoading) LeafLoading mLeafLoading;
    @BindView(R.id.fan_pic) ImageView mImageFan;
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_PROGRESS:
                    if (mProgress < 40) {
                        mProgress += 1;
                        // 随机800ms以内刷新一次
                        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS,
                                new Random().nextInt(800));
                        mLeafLoading.setProgress(mProgress);
                    } else {
                        mProgress += 1;
                        // 随机1200ms以内刷新一次
                        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS,
                                new Random().nextInt(1200));
                        mLeafLoading.setProgress(mProgress);
                    }
                    break;
                default:
                    break;
            }
        };
    };
    public LoadingDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.setContentView(LayoutInflater.from(context).inflate(R.layout.loading_base,null));
    }

    public LoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext= context;
        this.setContentView(LayoutInflater.from(context).inflate(R.layout.loading_base,null));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        RotateAnimation rotateAnimation= AnimationUtils.initRotateAnimation(false,1500,true, Animation.INFINITE);
        mImageFan.startAnimation(rotateAnimation);
        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS,3000);
    }
}
