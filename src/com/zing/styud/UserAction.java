package com.zing.styud;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    public String demo(){
        System.err.println("我执行了demo");
        return SUCCESS;
    }
}
