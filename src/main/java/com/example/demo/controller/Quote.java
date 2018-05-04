package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by go on 2018/4/27.
 */

@JsonIgnoreProperties
public class Quote {

    private String type;

    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
