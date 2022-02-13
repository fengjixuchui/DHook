package com.keven1z;

import com.keven1z.entity.AgentEntity;
import com.keven1z.service.IAgentService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author keven1z
 * @date 2022/01/04
 */
@Component
public class AgentUtil {
    @Resource
    private IAgentService agentService;

    public static AgentUtil agentUtil;
    @PostConstruct
    public void init() {
        agentUtil = this;
    }
    public static void update(AgentEntity agentEntity){
        agentUtil.agentService.update(agentEntity);
    }
}
