package com.fanwe.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.fanwe.library.utils.SDViewUtil;
import com.fanwe.live.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

/**
 * Created by Administrator on 2016/7/5.
 */
public class SDProgressLoadingLayout extends LoadingLayout
{

    private ImageView iv_pull_refresh;

    public SDProgressLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs)
    {
        super(context, mode, scrollDirection, attrs);
        View headerView = LayoutInflater.from(getContext()).inflate(R.layout.view_pull_refresh_header, null);

        iv_pull_refresh = (ImageView) headerView.findViewById(R.id.iv_pull_refresh);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        mInnerLayout.addView(headerView, params);

        setBackgroundColor(getResources().getColor(R.color.bg_activity));
        hideAllViews();
    }

    @Override
    protected int getDefaultDrawableResId()
    {
        return 0;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable)
    {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout)
    {

    }

    @Override
    protected void pullToRefreshImpl()
    {
        if (iv_pull_refresh != null)
        {
            iv_pull_refresh.setImageResource(R.drawable.ic_pull_refresh_normal);
        }
    }

    @Override
    protected void refreshingImpl()
    {
        if (iv_pull_refresh != null)
        {
            iv_pull_refresh.setImageResource(R.drawable.ic_pull_refresh_refreshing);
            SDViewUtil.startAnimationDrawable(iv_pull_refresh.getDrawable());
        }
    }

    @Override
    protected void releaseToRefreshImpl()
    {
        if (iv_pull_refresh != null)
        {
            iv_pull_refresh.setImageResource(R.drawable.ic_pull_refresh_ready);
        }
    }

    @Override
    protected void resetImpl()
    {
        if (iv_pull_refresh != null)
        {
            SDViewUtil.stopAnimationDrawable(iv_pull_refresh.getDrawable());
            iv_pull_refresh.setImageResource(R.drawable.ic_pull_refresh_normal);
        }
    }
}
