package com.pig4cloud.pigx.admin.api.dto;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import com.pig4cloud.pigx.common.core.util.ValidGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * 测试传输对象
 *
 * @author DC
 * @since 2023-04-05 23:01:18
 */
@Data
@Schema(description = "测试传输对象")
@TableName("test")
public class TestDTO implements Serializable {
    private static final long serialVersionUID = -95876714771381395L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @Null(groups = {ValidGroup.Insert.class}, message = "无效id")
    @NotNull(groups = ValidGroup.Update.class, message = "测试id不能为空")
    @Schema(description = "主键")
    private Long id;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;

    /**
     * 年龄
     */
    @Schema(description = "年龄")
    private Integer age;

}

