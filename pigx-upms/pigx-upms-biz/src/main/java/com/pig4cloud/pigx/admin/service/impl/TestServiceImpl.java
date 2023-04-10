package com.pig4cloud.pigx.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pigx.admin.api.dto.TestDTO;
import com.pig4cloud.pigx.admin.api.entity.Test;
import com.pig4cloud.pigx.admin.api.vo.TestVO;
import com.pig4cloud.pigx.admin.mapper.TestMapper;
import com.pig4cloud.pigx.admin.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 测试 服务层实现
 *
 * @author DC
 * @since 2023-04-05 23:01:35
 */
@Service
@AllArgsConstructor
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    private final TestMapper testMapper;


    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param testDTO 条件查询对象
     * @return IPage<TestVO> 查询结果
     */
    @Override
    public IPage<TestVO> queryPageList(IPage<Test> page, TestDTO testDTO) {
        return testMapper.queryPageList(page, testDTO);
    }

    /**
     * 通过id查询详情
     *
     * @param id 数据id
     * @return TestVO 响应数据
     * @description
     */
    @Override
    public TestVO queryTestVOById(Long id) {
        return testMapper.queryTestVOById(id);
    }

    /**
     * 通过id删除
     *
     * @param id 数据id集合
     * @return Boolean 布尔
     * @description
     */
    @Override
    public Boolean deleteTestById(Long id) {
        return this.removeById(id);
    }

    /**
     * 编辑
     *
     * @param testDTO 请求数据
     * @return Boolean 布尔
     * @description
     */
    @Transactional
    @Override
    public Boolean updateTest(TestDTO testDTO) {
        Test test = new Test();
        BeanUtils.copyProperties(testDTO, test);
        return this.updateById(test);
    }

    /**
     * 添加
     *
     * @param testDTO 请求数据
     * @return Boolean 布尔
     * @description
     */
    @Transactional
    @Override
    public Boolean saveTest(TestDTO testDTO) {
        Test test = new Test();
        BeanUtils.copyProperties(testDTO, test);
        return this.save(test);
    }

    /**
     * 设置默认值
     *
     * @description
     * @param test 实体类
     * @param userId 用户id
     * @param now    当前时间
     */
    //void setDefaultValues(Test test ,Long userId ,LocalDateTime now){
    //test .setAddUser(userId);
    //test .setAddTime(now);
    //test .setUpdUser(userId);
    //test .setUpdTime(now);
    //}
}

