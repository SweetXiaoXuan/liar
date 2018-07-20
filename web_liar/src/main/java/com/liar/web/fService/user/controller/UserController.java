package com.liar.web.fService.user.controller;

import com.liar.web.common.bean.ResultStruct;
import com.liar.web.common.utils.Constant;
import com.liar.web.common.utils.HttpRequest;
import com.liar.web.session.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/{device}/details/{aid}")
    @ResponseBody
    public String details(
            @PathVariable("device") String device,
            @PathVariable("aid") String aid,
            HttpServletRequest request) {
        String content;
        try {
            Object uid = request.getAttribute("uid");
            Object pid = request.getAttribute("pid");
            Object userType = request.getAttribute("userType");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("uid", uid);
            map.put("userType", userType);
            map.put("pid", pid);
            SessionService.save(request);
            String url = String.format(Constant.DETAILS, aid);
            content = HttpRequest.sendGet(url, map);
//            return Response.ok(content).build();
            return  content;
        } catch (Exception ex) {
//            return SystemException.setResult(result, ex, logger);;
            return "";
        }
    }
}
