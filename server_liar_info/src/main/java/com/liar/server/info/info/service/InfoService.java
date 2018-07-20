package com.liar.server.info.info.service;

import com.liar.server.info.info.daoBean.Info;
import com.liar.server.info.info.mapper.InfoMapper;
import com.liar.server.user.common.bean.ReturnValue;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService extends IoHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(InfoService.class);

    @Autowired
    private InfoMapper infoMapper;

    public ReturnValue userLogin(Info info) throws NullPointerException {
        ReturnValue resultBean = new ReturnValue();
        Info u = infoMapper.findWithLoginnameAndPassword(info.getUsername(), info.getPassword());
//        String username = infoMapper.login1(info.getUsername(), info.getPassword());
//        resultBean.setObject(username);
        resultBean.setObject(u);
        return resultBean;
    }

}
