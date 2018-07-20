package com.liar.web.common.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class ResultStruct {
    private String status = OK;
    private Object body = "null";
    private String msg = "";
    @JSONField(serialize = false, deserialize = false)
    public final static String OK = "0";
    @JSONField(serialize = false, deserialize = false)
    public final static String ERROR = "1";
    @JSONField(serialize = false, deserialize = false)
    public final static String PROTECT = "2";
    @JSONField(serialize = false, deserialize = false)
    public final static String NotAssess = "4";

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
