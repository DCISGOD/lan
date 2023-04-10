package com.pig4cloud.pigx.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pigx.admin.api.entity.Test;
import com.pig4cloud.pigx.admin.api.vo.TestVO;
import com.pig4cloud.pigx.admin.api.dto.TestDTO;

/**
 * 测试 服务层
 *
 * @author DC
 * @since 2023-04-05 23:01:35
 */
public interface TestService extends IService<Test> {

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param testDTO 条件查询对象
     * @return IPage<TestVO> 查询结果
     */
    IPage<TestVO> queryPageList(IPage<Test> page, TestDTO testDTO);

    /**
     * 通过rid查询详情
     *
     * @param id 数据id
     * @return TestVO 响应数据
     */
    TestVO queryTestVOById(Long id);

    /**
     * 通过id删除
     *
     * @param id 主键
     * @return Boolean 统一返回结果
     */
    Boolean deleteTestById(Long id);

    /**
     * 编辑
     *
     * @param testDTO 请求数据
     * @return Boolean 统一返回结果
     */
    Boolean updateTest(TestDTO testDTO);

    /**
     * 新增
     *
     * @param testDTO 请求数据
     * @return Boolean 统一返回结果
     */
    Boolean saveTest(TestDTO testDTO);
}

