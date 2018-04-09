package com.example.demo.domain;

/**
 * Created by go on 2017/7/19.
 */
public class UpdateEntity {


    private int code;

    private String apkDescription;

    private String url;

    private String versionName;

    private int versionCode;

    public String getApkDescription() {
        return apkDescription;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setApkDescription(String apkDescription) {
        this.apkDescription = apkDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }
}
