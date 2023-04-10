package com.pig4cloud.pigx.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pig4cloud.pigx.admin.api.dto.PolicyDTO;
import com.pig4cloud.pigx.admin.api.entity.Policy;
import com.pig4cloud.pigx.admin.api.vo.PolicyVO;
import com.pig4cloud.pigx.common.data.datascope.PigxBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 新闻资讯数据持久层
 *
 * @author DC
 * @since 2023-04-04 23:33:27
 */
@Mapper
public interface PolicyMapper extends PigxBaseMapper<Policy> {
    /**
     * 查询分页数据
     *
     * @param page    分页参数
     * @param policyDTO 条件参数
     * @return IPage<NewsVO>
     */
    IPage<PolicyVO> queryPageList(@Param("page") IPage<Policy> page,
                                  @Param("query") PolicyDTO policyDTO);

    /**
     * 通过id查询政策资讯信息
     *
     * @param id 主键
     * @return NewsVO
     */
    PolicyVO queryPolicyVOById(Long id);
}

