package com.pig4cloud.pigx.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pig4cloud.pigx.admin.api.dto.TestDTO;
import com.pig4cloud.pigx.admin.api.entity.Test;
import com.pig4cloud.pigx.admin.api.vo.TestVO;
import com.pig4cloud.pigx.common.data.datascope.PigxBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试数据持久层
 *
 * @author DC
 * @since 2023-04-05 23:01:35
 */
@Mapper
public interface TestMapper extends PigxBaseMapper<Test> {
    /**
     * 查询分页数据
     *
     * @param page    分页参数
     * @param testDTO 条件参数
     * @return IPage<TestVO>
     * @description
     */
    IPage<TestVO> queryPageList(@Param("page") IPage<Test> page,
                                @Param("query") TestDTO testDTO);

    /**
     * 通过id查询测试信息
     *
     * @param id
     * @return TestVO
     */
    TestVO queryTestVOById(Long id);

}

