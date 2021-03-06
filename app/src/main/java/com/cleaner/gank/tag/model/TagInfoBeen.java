package com.cleaner.gank.tag.model;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * Created by mjd on 2017/2/7.
 */

public class TagInfoBeen implements Serializable {

    public String _id;
    public String createdAt;
    public String desc;
    public String publishedAt;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String who;
    public List<String> images;

    public boolean isRead; //标记是否阅读过

    @Override
    public String toString() {
        return "TagInfoBeen{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who=" + who +
                ", images=" + images +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        String id = ((TagInfoBeen) obj)._id;
        return this._id.equals(id);
    }
}
