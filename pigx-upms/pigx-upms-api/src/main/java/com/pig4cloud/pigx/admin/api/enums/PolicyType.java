package com.pig4cloud.pigx.admin.api.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author DC
 */
public enum PolicyType {
    NEWS(1, "新闻资讯"),
    POLICIES_AND_REGULATIONS(2, "政策法规"),
    NOTIFICATION_ANNOUNCEMENTS(3, "通知公告"),
    BASE_LAND_PRICE(4, "基准地价");

    @EnumValue
    private int value;
    @JsonValue
    private String desc;

    PolicyType(Integer value, String desc) {
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
