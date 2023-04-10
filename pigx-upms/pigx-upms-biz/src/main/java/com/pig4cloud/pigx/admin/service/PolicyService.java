package com.pig4cloud.pigx.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pigx.admin.api.dto.PolicyDTO;
import com.pig4cloud.pigx.admin.api.entity.Policy;
import com.pig4cloud.pigx.admin.api.vo.PolicyVO;

/**
 * @author DC
 */
public interface PolicyService extends IService<Policy> {

    IPage<PolicyVO> queryPageList(IPage<Policy> page, PolicyDTO policyDTO);

    /**
     * 通过id查询政策资讯信息
     *
     * @param id
     * @return NewsVO
     */
    PolicyVO queryPolicyVoById(Long id);

    Boolean savePolicy(PolicyDTO policyDTO);


    Boolean updatePolicy(PolicyDTO policyDTO);


    Boolean publishPolicy(Long id);
}
