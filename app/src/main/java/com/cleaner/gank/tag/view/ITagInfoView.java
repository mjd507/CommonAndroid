package com.cleaner.gank.tag.view;

import com.cleaner.gank.tag.model.TagInfoBeen;

import java.util.List;

import common.http.common.Listener;

/**
 * 描述:
 * Created by mjd on 2017/2/7.
 */

public interface ITagInfoView {

    void showSuccessView(List<TagInfoBeen> results);

    void showErrorView(Listener.ErrorType errorType);

    void hideLoading();

    void showLoading();
}
