package com.qyb.pojo;/*

亲元宝 2019/10/29  11:23
元宝

*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String username;
    private String password;
    private String captcha;
    private boolean rememberMe;
}
