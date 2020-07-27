package com.demo.common;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    public int code;
    public Map<String,Object> extend=new HashMap<String,Object>();


    public static Msg fail() {
        Msg result =new Msg();
        result.setCode(200);
        return result;
    }
    public Msg add(String key, Object value){
        this.getExtend().put(key,value);
        return this;
    }


    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;

    }

    public static Msg success(){
        Msg result =new Msg();
        result.setCode(100);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }





}
