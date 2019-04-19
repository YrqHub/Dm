package com.yang.dm.mvp.model;

import java.util.List;

/**
 * Describe:
 * Created by Yang on 2019/1/22.
 */
public class OpenResponse<T> {


    /**
     * code : 200
     * message : 成功!
     * result : [{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/discovery","name":"发现","tabType":0,"id":-1,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0","name":"推荐","tabType":0,"id":-2,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/feed","name":"日报","tabType":0,"id":-3,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/ugcSelected","name":"社区","tabType":0,"id":-4,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/14","name":"广告","tabType":0,"id":14,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/36","name":"生活","tabType":0,"id":36,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/10","name":"动画","tabType":0,"id":10,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/28","name":"搞笑","tabType":0,"id":28,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/4","name":"开胃","tabType":0,"id":4,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/2","name":"创意","tabType":0,"id":2,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/18","name":"运动","tabType":0,"id":18,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/20","name":"音乐","tabType":0,"id":20,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/26","name":"萌宠","tabType":0,"id":26,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/12","name":"剧情","tabType":0,"id":12,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/32","name":"科技","tabType":0,"id":32,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/6","name":"旅行","tabType":0,"id":6,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/8","name":"影视","tabType":0,"id":8,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/22","name":"记录","tabType":0,"id":22,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/30","name":"游戏","tabType":0,"id":30,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/38","name":"综艺","tabType":0,"id":38,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/24","name":"时尚","tabType":0,"id":24,"adTrack":null},{"nameType":0,"apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/category/34","name":"集锦","tabType":0,"id":34,"adTrack":null}]
     */

    private int code;
    private String message;
    private List<T> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
