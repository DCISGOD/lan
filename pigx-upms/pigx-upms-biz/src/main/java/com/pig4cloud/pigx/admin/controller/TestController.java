package com.pig4cloud.pigx.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pigx.admin.api.dto.TestDTO;
import com.pig4cloud.pigx.admin.api.entity.Test;
import com.pig4cloud.pigx.admin.api.vo.TestVO;
import com.pig4cloud.pigx.admin.service.PolicyService;
import com.pig4cloud.pigx.admin.service.TestService;
import com.pig4cloud.pigx.common.core.util.R;
import com.pig4cloud.pigx.common.core.util.ValidGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 测试控制层
 *
 * @author DC
 * @since 2023-04-05 23:01:35
 */
@AllArgsConstructor
@Tag(description = "测试", name = "测试管理模块")
@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    /**
     * 分页查询测试所有数据
     *
     * @param page    页面参数请求
     * @param testDTO 测试传输对象
     * @return R<IPage < TestVO>> 统一返回结果
     */

    @GetMapping("/page")
    @Operation(description = "测试列表条件查询", summary = "测试分页查询")
    public R<IPage<TestVO>> getTestPage(Page page, TestDTO testDTO) {
        return R.ok(testService.queryPageList(page, testDTO));
    }

    /**
     * 通过id查询测试详情
     *
     * @param id 主键id
     * @return R<TestVO> 统一返回结果
     */
    @GetMapping("/{id}")
    @Operation(description = "通过id查询测试详情", summary = "通过id查询测试详情")
    public R<TestVO> queryTestVOById(@PathVariable("id") Long id) {
        return R.ok(testService.queryTestVOById(id));
    }

    /**
     * 通过id删除测试
     *
     * @param id 主键id集合
     * @return R 布尔
     */
    @DeleteMapping("/{id}")
    @Operation(description = "通过id删除测试", summary = "通过id删除测试")
    R<Boolean> deleteTestById(@PathVariable("id") Long id) {
        return R.ok(testService.removeById(id));
    }

    /**
     * 编辑
     *
     * @param testDTO 请求数据
     * @return R 布尔
     */
    @PutMapping
    @Operation(description = "编辑测试", summary = "编辑测试")
    R<Boolean> updateTest(@Validated(value = {ValidGroup.Update.class}) @RequestBody TestDTO testDTO) {
        return R.ok(testService.updateTest(testDTO));
    }

    /**
     * 新增
     *
     * @param testDTO 请求数据
     * @return R 布尔
     */
    @PostMapping
    @Operation(description = "新增测试", summary = "新增测试")
    R<Boolean> insertTest(@Validated(value = {ValidGroup.Insert.class}) @RequestBody TestDTO testDTO) {
        return R.ok(testService.saveTest(testDTO));
    }
}

