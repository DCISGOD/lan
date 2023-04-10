package com.pig4cloud.pigx.admin.api.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pig4cloud.pigx.admin.api.enums.PolicyType;
import com.pig4cloud.pigx.common.core.util.ValidGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * 政策资讯传输对象
 *
 * @author DC
 * @since 2023-04-04 22:29:46
 */
@Data
@Schema(description = "政策资讯传输对象")
public class PolicyDTO implements Serializable {
    private static final long serialVersionUID = -10078060789851622L;

    /**
     * 政策资讯id
     */
    @TableId(value = "policy_id", type = IdType.ASSIGN_ID)
    @Null(groups = {ValidGroup.Insert.class}, message = "无效id")
    @NotNull(groups = ValidGroup.Update.class, message = "政策资讯id不能为空")
    private Long policyId;

    /**
     * 政策资讯标题
     */
    @NotNull(groups = {ValidGroup.Insert.class}, message = "政策资讯标题不能为空")
    @Schema(description = "政策资讯标题")
    private String policyTitle;

    /**
     * 信息来源
     */
    @NotNull(groups = {ValidGroup.Insert.class}, message = "信息来源不能为空")
    @Schema(description = "信息来源")
    private String sourceOfInfo;

    /**
     * 政策资讯内容
     */
    @NotNull(groups = {ValidGroup.Insert.class}, message = "政策资讯内容不能为空")
    @Schema(description = "政策资讯内容")
    private String policyContent;

    @NotNull(groups = {ValidGroup.Insert.class}, message = "政策资讯类型不能为空")
    @Schema(description = "政策资讯类型")
    private PolicyType policyType;


}

