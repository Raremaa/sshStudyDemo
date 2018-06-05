package com.zing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zing.service.UserService;

public class UserAction extends ActionSupport {
    private UserService userService;
    public String demo(){
        System.err.println("我执行了demo");
        return SUCCESS;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public String login() throws Exception {
        System.err.println(userService);
        return super.execute();
    }
}
