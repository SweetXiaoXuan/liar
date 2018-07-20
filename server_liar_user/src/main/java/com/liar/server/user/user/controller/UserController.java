package com.liar.server.user.user.controller;

import com.alibaba.fastjson.JSON;
import com.liar.server.user.common.bean.ResultStruct;
import com.liar.server.user.common.bean.ReturnValue;
import com.liar.server.user.common.utils.Constant;
import com.liar.server.user.common.utils.HttpRequest;
import com.liar.server.user.common.utils.SystemException;
import com.liar.server.user.user.daoBean.User;
import com.liar.server.user.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import java.util.HashMap;
import java.util.Map;

@Controller
//@RestController
@EnableAutoConfiguration
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{device}/details/{aid}")
    @ResponseBody
    public String details(
            @PathVariable("device") String device,
            @PathVariable("aid") String aid,
            @Context HttpServletRequest request) {
        ResultStruct result = new ResultStruct();
        String content;
        try {
            Map<String, Object> map = new HashMap<>();
            String url = String.format(Constant.DETAILS, aid);
            content = HttpRequest.sendGet(url, map);
            return content;
        } catch (Exception ex) {
            return JSON.toJSONString(SystemException.setResult(result, ex, logger));
        }
    }

    @GetMapping("/{device}/userLogin")
    @ResponseBody
    public ResultStruct userLogin(
            @PathVariable("device") String device,
            @FormParam("username") String username,
            @FormParam("password") String password,
            @Context HttpServletRequest request) {
        ResultStruct result = new ResultStruct();
        String content="";
        try {
            User u =new User();
            u.setUsername(username);
            u.setPassword(password);
            ReturnValue rb = userService.userLogin(u);
            result = ResultStruct.setResultStructInfo(rb, result);
            return result;
        } catch (Exception ex) {
//            return SystemException.setResult(result, ex, logger);
            logger.error(ex.getMessage(), ex);
            return result;
        }
    }

}
