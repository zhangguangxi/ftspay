package com.fx.wechat.controller;

import com.fx.common.dto.ResultDTO;
import com.fx.wechat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JONES on 2017/12/27.
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

   @Autowired
   private LoginService loginService;

    @PostMapping(value = "/login")
    public ResultDTO queryCarList(HttpServletRequest request, HttpServletResponse response){

        return null;
    }
}
