package com.pig4cloud.pigx.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pigx.admin.api.dto.PolicyDTO;
import com.pig4cloud.pigx.admin.api.entity.Policy;
import com.pig4cloud.pigx.admin.api.vo.PolicyVO;
import com.pig4cloud.pigx.admin.service.PolicyService;
import com.pig4cloud.pigx.common.core.util.R;
import com.pig4cloud.pigx.common.core.util.ValidGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 政策资讯控制层
 *
 * @author DC
 * @since 2023-04-04 23:32:19
 */
@AllArgsConstructor
@Tag(description = "政策资讯", name = "政策资讯管理模块")
@RestController
@RequestMapping("/policy")
public class PolicyController {

    private final PolicyService newsService;

    /**
     * 分页查询所有数据
     *
     * @param page 页面参数请求
     * @return R 统一返回结果
     */

    @GetMapping("/page")
    @Operation(description = "政策列表条件查询", summary = "政策分页查询")
    public R<IPage<PolicyVO>> getUserPage(Page<Policy> page, PolicyDTO policyDTO) {
        return R.ok(newsService.queryPageList(page, policyDTO));
    }

    /**
     * 通过id查询详情
     *
     * @param id 主键id
     * @return R 统一返回结果
     */
    @GetMapping("/{id}")
    @Operation(description = "政策详情通过id查询", summary = "政策详情查询")
    R<PolicyVO> queryNewsId(@PathVariable("id") Long id) {
        return R.ok(newsService.queryPolicyVoById(id));
    }

    /**
     * 通过id批量删除
     *
     * @param id 主键id集合 多个rid用英文,隔开
     * @return R 统一返回结果
     */
    @DeleteMapping("/{id}")
    @Operation(description = "删除政策通过id", summary = "删除政策")
    R<Boolean> deleteNewsById(@PathVariable("id") Long id) {
        return R.ok(newsService.removeById(id));
    }

    /**
     * 编辑
     *
     * @param policyDTO 请求数据
     * @return R 统一返回结果
     */
    @PutMapping
    @Operation(description = "编辑政策", summary = "编辑政策")
    R<Boolean> updateNews(@Validated(value = {ValidGroup.Update.class}) @RequestBody PolicyDTO policyDTO) {
        return R.ok(newsService.updatePolicy(policyDTO));
    }

    /**
     * 新增
     *
     * @param policyDTO 请求数据
     * @return R 统一返回结果
     */
    @PostMapping
    @Operation(description = "新增政策", summary = "新增政策")
    R<Boolean> insertNews(@Validated(value = {ValidGroup.Insert.class}) @RequestBody PolicyDTO policyDTO) {
        return R.ok(newsService.savePolicy(policyDTO));
    }

    @PutMapping("/publish/{id}")
    @Operation(description = "发布政策", summary = "发布政策")
    R<Boolean> publishNews(@PathVariable Long id) {
        return R.ok(newsService.publishPolicy(id));
    }


}

