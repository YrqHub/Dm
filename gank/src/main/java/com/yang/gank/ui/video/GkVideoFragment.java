package com.yang.gank.ui.video;


import com.yang.gank.R;
import com.yang.gank.base.GankFragment;
import com.yang.gank.mvp.presenter.VideoPresenter;


import javax.inject.Inject;


/**
 * Describe: 视频
 * @author Created by Yang on 2019/1/3.
 */
public class GkVideoFragment extends GankFragment{
    @Inject
    VideoPresenter mPresenter;



    @Override
    protected int bindLayout() {
        return R.layout.fragment_gk_video;
    }

    @Override
    protected void initView() {


    }


}
