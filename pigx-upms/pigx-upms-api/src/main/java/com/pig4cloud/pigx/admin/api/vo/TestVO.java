package com.pig4cloud.pigx.admin.api.vo;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 前端测试展示对象
 *
 * @author DC
 * @since 2023-04-05 23:01:18
 */
@Data
@Schema(description = "前端测试展示对象")
@TableName("test")
public class TestVO implements Serializable {
    private static final long serialVersionUID = -40887501603592485L;

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

