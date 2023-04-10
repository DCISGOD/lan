package com.pig4cloud.pigx.admin.api.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author DC
 */

public enum PolicyStatus {
    NOT_PUBLISHED(0, "未发布"),
    PUBLISHED(1, "已发布");

    @EnumValue
    private int value;
    @JsonValue
    private String desc;

    PolicyStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}