package com.example.bookback.controller;


import com.example.bookback.entity.User;
import com.example.bookback.service.UserService;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgCode;
import com.example.bookback.utils.msgutils.MsgUtil;
import com.example.bookback.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;



@RestController
public class LoginController {


    @Autowired
    private UserService userService;

    @RequestMapping("/login")

    public Msg login(@RequestBody Map<String, String> params){

        String username=params.get("username");
        String password=params.get("password");
        User auth = userService.checkUser(username, password);
        if(auth != null){

            //若成功登录则把用户信息存入session
            JSONObject obj = new JSONObject();
            obj.put("userId", auth.getUserId());
            obj.put("username", auth.getName());
            obj.put("userType", auth.getUserType());
            SessionUtil.setSession(obj);

            JSONObject data = JSONObject.fromObject(auth);
            data.remove(password);

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        }
    }

    @RequestMapping("/logout")
    public Msg logout(){
        Boolean status = SessionUtil.removeSession();

        if(status){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGOUT_SUCCESS_MSG);
        }
        return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.LOGOUT_ERR_MSG);
    }


    @RequestMapping("/checkSession")
    public Msg checkSession(){
        JSONObject auth = SessionUtil.getAuth();

        if(auth == null){
            return MsgUtil.makeMsg(MsgCode.NOT_LOGGED_IN_ERROR);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, auth);
        }
    }
}
