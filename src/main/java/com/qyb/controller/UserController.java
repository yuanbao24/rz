package com.qyb.controller;/*

亲元宝 2019/10/29  11:04
元宝

*/

import com.qyb.pojo.User;
import com.qyb.pojo.UserVo;
import com.qyb.service.UserService;
import com.qyb.utils.Captcha2;
import com.qyb.utils.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/sys")
@CrossOrigin("http://localhost:8988")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAllUser();
    }

    @PostMapping("/login")
    @ResponseBody
    public R login(@RequestBody UserVo userVo){
        System.out.println("111111111");
        System.out.println(userVo);
        UsernamePasswordToken token=new UsernamePasswordToken(userVo.getUsername(),userVo.getPassword());
        System.out.println("token");
        System.out.println(token);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return R.ok();

    }

    //验证码
    @RequestMapping("/getCode")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("yczycz");
        Captcha2.generateCaptcha(request, response);
    }
}
