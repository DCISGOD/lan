package com.pig4cloud.pigx.admin.api.vo;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import com.pig4cloud.pigx.admin.api.enums.PolicyStatus;
import com.pig4cloud.pigx.admin.api.enums.PolicyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 前端政策资讯展示对象
 *
 * @author DC
 * @since 2023-04-04 22:29:46
 */
@Data
@Schema(description = "前端政策资讯展示对象")
public class PolicyVO implements Serializable {
    private static final long serialVersionUID = 928703734574102720L;

    /**
     * 新闻id
     */
    @TableId(value = "policy_id", type = IdType.ASSIGN_ID)
    private Long policyId;

    /**
     * 政策资讯标题
     */
    @Schema(description = "政策资讯标题")
    private String policyTitle;

    /**
     * 政策资讯状态
     */
    @Schema(description = "政策资讯状态 0 未发布 1已发布")
    private PolicyStatus policyStatus;

    /**
     * 信息来源
     */
    @Schema(description = "信息来源")
    private String sourceOfInfo;

    /**
     * 政策资讯内容
     */
    @Schema(description = "政策资讯内容")
    private String policyContent;

    /**
     * 发布时间
     */
    @Schema(description = "发布时间")
    private LocalDateTime releaseTime;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    private String createBy;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    @Schema(description = "修改人")
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除 1已删除 0正常
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "逻辑删除 1已删除 0正常")
    private String delFlag;

    @Schema(description = "政策资讯类型： 1新闻资讯 2政策法规 3通知公告 4基准地价")
    private PolicyType policyType;

}

