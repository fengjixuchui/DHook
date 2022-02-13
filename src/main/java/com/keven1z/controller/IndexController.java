package com.keven1z.controller;

import com.keven1z.entity.AgentEntity;
import com.keven1z.service.IAgentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author keven1z
 * @date 2021/12/27
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Resource
    public IAgentService agentService;
    /**
     * 推送给所有用户
     * @return
     */
    @GetMapping("/index.html")
    public String index(){
        return "index";
    }
    @GetMapping("/hook.html")
    public String hook(HttpServletRequest request,@RequestParam(value = "id", required = true)String id){
        AgentEntity agentById = agentService.findAgentById(id);
        request.setAttribute("id",id);
        request.setAttribute("applicationName",agentById.getName());
        return "hook";
    }

}