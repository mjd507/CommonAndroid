package com.cleaner.gank.tag.model;

import android.support.annotation.NonNull;

import com.android.volley.VolleyError;
import com.cleaner.gank.Urls;

import java.util.List;

import common.http.volley.HttpResponse;
import common.http.volley.HttpTask;
import common.utils.LogUtils;

import static com.android.volley.VolleyLog.TAG;

/**
 * 描述:
 * Created by mjd on 2017/2/7.
 */

public class TagInfoProvider {

    private TagInfoListener tagInfoListener;

    public TagInfoProvider(@NonNull TagInfoListener tagInfoListener) {
        this.tagInfoListener = tagInfoListener;
    }

    public void getTagInfo(String category, String page) {
        //每页返回十条数据
        String url = Urls.GET_CATEGORY_INFO + category + "/" + 10 + "/" + page;

        HttpTask task = new HttpTask();
        task.url = url;
        task.isPost = false;
        task.isShowLoadingDialog = true;
        task.tag = category;
        task.setListener(new HttpTask.Listener() {
            @Override
            public void showLoading() {
                tagInfoListener.showLoading();
            }

            @Override
            public void hideLoading() {
                tagInfoListener.hideLoading();
            }

            @Override
            public void netUnConnect() {
                tagInfoListener.netUnConnect();
            }

            @Override
            public void onResponse(HttpResponse response) {
                handlerResponse(response);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                tagInfoListener.onError(error);
            }
        });
        task.start();

    }

    private void handlerResponse(HttpResponse response) {
        boolean error = response.getState("error");
        List<TagInfoBeen> results = null;
        if (error) {
            LogUtils.d(TAG, "response error !");
        } else {
            results = response.getList("results");
        }
        tagInfoListener.onSuccess(results);
    }


}