package com.sanwenyu.stemplate.ui.main.fragment;

import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.ui.news.activity.AboutActivity;
import com.jaydenxiao.androidfire.ui.zone.activity.CircleZoneActivity;
import com.sanwenyu.stemplate.base.BaseFragment;
import com.jaydenxiao.common.commonutils.ImageLoaderUtils;
import com.jaydenxiao.common.commonwidget.WaveView;
import com.jaydenxiao.common.daynightmodeutils.ChangeModeController;
import com.sanwenyu.stemplate.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * des:关于我的主页
 * Created by lzc
 * on 2020.1.27
 */
public class MineMainFragment extends BaseFragment {
    @Bind(R.id.ll_friend_zone)
    LinearLayout llFriendZone;
    @Bind(R.id.wave_view)
    WaveView waveView;
    @Bind(R.id.img_logo)
    ImageView imgLogo;

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_care_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        //设置头像跟着波浪背景浮动
        ImageLoaderUtils.displayRound(getContext(),imgLogo,R.drawable.bgkobe);
        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.CENTER;
        waveView.setOnWaveAnimationListener(new WaveView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                lp.setMargins(0,0,0,(int)y+2);
                imgLogo.setLayoutParams(lp);
            }
        });
    }
    @OnClick(R.id.ll_friend_zone)
    public void friendZone(){
        CircleZoneActivity.startAction(getContext());
    }
    @OnClick(R.id.ll_daynight_toggle)
    public void dayNightToggle(){
        ChangeModeController.toggleThemeSetting(getActivity());
    }
    @OnClick(R.id.ll_daynight_about)
    public void about(){
        AboutActivity.startAction(getContext());
    }
}
