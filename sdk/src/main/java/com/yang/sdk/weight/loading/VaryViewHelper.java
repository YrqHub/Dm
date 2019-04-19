package com.yang.sdk.weight.loading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Describe:  加载view助手类
 * Created by Yang on 2019/4/15.
 */
public class VaryViewHelper implements IVaryViewHelper {
    private View mView;
    private ViewGroup parentView;
    private int viewIndex;
    private ViewGroup.LayoutParams params;
    private View currentView;

    public VaryViewHelper(View view) {
        super();
        mView = view;
    }

    private void init() {
        params = mView.getLayoutParams();
        if (mView.getParent() != null) {
            parentView = (ViewGroup) mView.getParent();
        } else {
            parentView = mView.getRootView().findViewById(android.R.id.content);
        }
        int count = parentView.getChildCount();
        for (int index = 0; index < count; index++) {
            if (mView == parentView.getChildAt(index)) {
                viewIndex = index;
                break;
            }
        }
        currentView = mView;
    }

    @Override
    public View getCurrentLayout() {
        return currentView;
    }

    @Override
    public void restoreView() {
        showLayout(mView);
    }

    @Override
    public void showLayout(View view) {
        if (parentView == null) {
            init();
        }
        currentView = view;
        // 如果已经是那个view，那就不需要再进行替换操作了
        if (parentView.getChildAt(viewIndex) != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
            parentView.removeViewAt(viewIndex);
            parentView.addView(view, viewIndex, params);
        }
    }

    @Override
    public View inflate(int layoutId) {
        return LayoutInflater.from(mView.getContext()).inflate(layoutId, null);
    }

    @Override
    public Context getContext() {
        return mView.getContext();
    }

    @Override
    public View getView() {
        return mView;
    }
}
