package com.pig4cloud.pigx.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pigx.admin.api.dto.PolicyDTO;
import com.pig4cloud.pigx.admin.api.entity.Policy;
import com.pig4cloud.pigx.admin.api.enums.PolicyStatus;
import com.pig4cloud.pigx.admin.api.vo.PolicyVO;
import com.pig4cloud.pigx.admin.mapper.PolicyMapper;
import com.pig4cloud.pigx.admin.service.PolicyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author DC
 */
@Slf4j
@Service
@AllArgsConstructor
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements PolicyService {
    private final PolicyMapper policyMapper;


    @Override
    public IPage<PolicyVO> queryPageList(IPage<Policy> page, PolicyDTO policyDTO) {
        return policyMapper.queryPageList(page, policyDTO);
    }

    @Override
    public PolicyVO queryPolicyVoById(Long id) {
        return policyMapper.queryPolicyVOById(id);
    }

    @Override
    public Boolean savePolicy(PolicyDTO policyDTO) {
        Policy policy = new Policy();
        BeanUtils.copyProperties(policyDTO, policy);
        policy.setPolicyStatus(PolicyStatus.NOT_PUBLISHED);
        return this.save(policy);
    }

    @Override
    public Boolean updatePolicy(PolicyDTO policyDTO) {
        Policy check = this.getById(policyDTO.getPolicyId());
        if (check.getPolicyStatus().equals(PolicyStatus.PUBLISHED)){
            throw new RuntimeException("已发布的内容不能更改");
        }
        Policy policy = new Policy();
        BeanUtils.copyProperties(policyDTO, policy);
        return this.updateById(policy);
    }

    @Override
    public Boolean publishPolicy(Long id) {
        Policy policy = new Policy();
        policy.setPolicyId(id);
        policy.setPolicyStatus(PolicyStatus.PUBLISHED);
        policy.setReleaseTime(LocalDateTime.now());
        return this.updateById(policy);
    }
}
