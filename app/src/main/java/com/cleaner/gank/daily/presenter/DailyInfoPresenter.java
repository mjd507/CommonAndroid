package com.cleaner.gank.daily.presenter;

import com.cleaner.gank.daily.model.DailyBeen;
import com.cleaner.gank.daily.model.DailyInfoListener;
import com.cleaner.gank.daily.model.DailyInfoProvider;
import com.cleaner.gank.daily.view.IDailyView;

import java.util.Date;
import java.util.List;

import common.http.common.ErrorType;

/**
 * 描述:
 * Created by mjd on 2017/2/8.
 */

public class DailyInfoPresenter implements DailyInfoListener {

    private IDailyView dailyView;
    private DailyInfoProvider infoProvider;

    public DailyInfoPresenter(IDailyView dailyView) {
        this.dailyView = dailyView;
    }

    public void getDailyInfo(Date date) {
        infoProvider = new DailyInfoProvider(this);
        infoProvider.getDailyInfoFromNet(date);
    }

    public void cancelAll() {
        if (infoProvider != null)
            infoProvider.cancelAll();
    }

    @Override
    public void showLoading() {
        dailyView.showLoading();
    }

    @Override
    public void hideLoading() {
        dailyView.hideLoading();
    }

    @Override
    public void onSuccess(List<DailyBeen> results) {
        dailyView.showSuccessView(results);
    }

    @Override
    public void onError(ErrorType error) {
        dailyView.showErrorView(error);
    }

}
