package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 授权相关
 * @author xpoll
 * @date 2019年4月10日
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value="/get", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<UserInfo> auth(String workNumber, String departmentCode, String username) {
    	return authService.getUserInfo(String.join("|", workNumber,departmentCode,username));
    }

}
