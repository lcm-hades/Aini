package com.hades.aini.vip.bean;

import java.io.Serializable;

/**
 * Created by Hades on 2016/8/30.
 */
public class VipInfoBean implements Serializable {

    private int id;
    private String name;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
