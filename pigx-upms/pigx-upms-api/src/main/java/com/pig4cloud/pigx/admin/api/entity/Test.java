package com.pig4cloud.pigx.admin.api.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 测试实体类
 *
 * @author DC
 * @since 2023-04-05 23:01:18
 */
@Data
@Schema(description = "测试实体类")
@TableName("test")
public class Test implements Serializable {
    private static final long serialVersionUID = -61724134381262870L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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

